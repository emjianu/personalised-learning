/**
 * Created by E-M on 4/9/2017.
 */
import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';

import {ActivatedRoute, Params} from "@angular/router";

import {Location} from '@angular/common';

import 'rxjs/add/operator/switchMap';
import {Question} from "./question";
import {QuestionService} from "./question.service";
import {Lesson} from "../lesson/lesson";
import {User} from "../login/user";


@Component({
  selector: 'question',
  /* template: '<h1>{{lesson.title}}</h1>',*/
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css'],
  providers: [QuestionService]
})
export class QuestionComponent implements OnInit {

  errorMsg: string;
  question: Question;
  user: User;

  lesson: Lesson;
  answered: boolean;
  correct: boolean;

  sessionScore: number;

  str: string;

  @Output() onAnswer = new EventEmitter<User>();

  constructor(private questionService: QuestionService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {

    this.user = JSON.parse(sessionStorage.getItem("currentUser"));
    this.lesson = new Lesson();
    this.getQuestion();

    this.user.sessionXp = 0;

  }

  getQuestion(): any{
    this.question = null;
    this.answered = false;

    this.correct = false;
    this.str = "";
    this.route.params
      .switchMap((params: Params) => {
        console.log(params);
        console.log(this.user);

        this.lesson.id = params.id;

        //for user 1 and lesson 1
        return this.questionService.getQuestion(this.user.id, params.id);

      })
      .subscribe(question => {
        console.log(question)
        console.log(question.currentChoices)
        this.question = question;
      });
  }


  sendAns(): string {
    this.user = JSON.parse(sessionStorage.getItem("currentUser"));
    console.log(this.question.answer);
    if (!this.question.answer) {
      return;
    }
    this.questionService.sendAnswer(this.question.id, this.question.lesson.id, this.question.answer, this.question.appliedDifficulty, this.user.id, this.user.xp, this.user.level)
      .then(result => {
        console.log("received");
        this.answered = true;


        if (result.correct) {

          this.correct = true;
          console.log("was correct")
          this.sessionScore += 10;
          this.str = '<span class="correct">CORRECT </strong></span>';



          this.onAnswer.emit(this.user);
        } else {
          this.correct = false;
          console.log("was incorrect")
          this.sessionScore += 5;
          this.onAnswer.emit(this.user);
          this.str = '<span class="error">INCORRECT!</strong></span>';
        }
        console.log(result)
      });
  }


  getColor() {
    if(!this.answered) {
      return "black";
    } else {
      return "lightgray";
    }
  }

  getTextColor() {
    if(!this.answered) {
      return "black";
    } else {
      return "#B1ACB1";
    }
  }

  getRadioColor() {
    if(this.answered) {
      return "lightgrey";
    }
  }

  getSH() {
    if(this.answered) {
      return "none";
    }
  }



}
