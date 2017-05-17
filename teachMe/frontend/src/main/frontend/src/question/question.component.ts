/**
 * Created by E-M on 4/9/2017.
 */
import {Component, OnInit, Input} from '@angular/core';

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

  str: string;

  constructor(private questionService: QuestionService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {

    this.user = JSON.parse(sessionStorage.getItem("currentUser"));
    this.lesson = new Lesson();
    this.getQuestion();


  }

  getQuestion(): any{
    this.question = null;
    this.answered = false;
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
          console.log("was correct")
          this.str = '<span class="correct">CORRECT!</strong></span>';
        } else {
          console.log("was incorrect")
          this.str = '<span class="error">INCORRECT!</strong></span>';
        }
        console.log(result)
      });
  }


}
