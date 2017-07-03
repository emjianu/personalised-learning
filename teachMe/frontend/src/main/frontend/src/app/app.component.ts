import {Component, OnInit} from '@angular/core';
import {LessonService} from "../lesson/lesson.service";
import {User} from "../login/user";
import {Question} from "../question/question";
import {SharedService} from "./SharedService";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [LessonService]

})
export class AppComponent implements OnInit {
  title = 'app works!';


  isVisible: boolean;

  user: User;

  color: string;

  constructor(private sharedService: SharedService) {
    sharedService.changeEmitted$.subscribe(
      question => {
        console.log(question);
        this.setColor(question);
      });
  }


  loggedIn(): boolean{
    this.user = JSON.parse(sessionStorage.getItem('currentUser'));

    if(this.user != null){
      return true;
    } else {
      this.isVisible = false;
      return false;
    }
  }

  ngOnInit() {
    this.isVisible = false;

    console.log(this.isVisible);

    this.color = "#F6F5F5";

   // this.color = "white";
  }


  setColor(question) {
    console.log("qq??");

    if(question.id == 0){
      this.color = "#F6F5F5";
    } else if(question.answeredBefore && question.latestStatus){

      this.color = "#e5e7f3";
      console.log("qq?? before corect");
      //this.color = "#C0C4DF";
      console.log(this.color);

    } else if(question.answeredBefore && !question.latestStatus){
      this.color = "#FFEFEF";
      console.log("qq?? before wrong");
      //this.color = "#FFF0F0";

      console.log(this.color);

    } else if(!question.answeredBefore){
      console.log("qq?? new");
      console.log(this.color);
      this.color = "#F6F5F5";
    }
  }

/*
  getQuestionType(question: Question) {
    console.log("qq??");
    if(question.answeredBefore && question.latestStatus){

     // this.color = "#e5e7f3";
      console.log("qq?? before corect");
      this.color = "#C0C4DF";
      console.log(this.color);
    } else if(question.answeredBefore && !question.latestStatus){
      //this.color = "#fff7f7";
      console.log("qq?? before wrong");
      this.color = "#FFF0F0";

      console.log(this.color);
    } else if(!question.answeredBefore){
      console.log("qq?? new");
      console.log(this.color);
      this.color = "#F6F5F5";
    }
  }
*/

/*
  getQuestionType() {
    console.log(this.color);
   return this.color;
  }
*/


  /*
   lessons: Lesson[];
   errorMessage: string;

   constructor(private lessonService: LessonService) {
   }


   ngOnInit() {
   this.getLessons();
   }

   getLessons() {
   this.lessonService.getAllLessons()
   .subscribe(
   lessons => this.lessons = lessons,
   error => this.errorMessage = <any>error);
   console.log(this.lessons)
   }*/


}
