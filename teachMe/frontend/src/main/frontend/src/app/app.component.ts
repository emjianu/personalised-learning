import {Component, OnInit} from '@angular/core';
import {LessonService} from "../lesson/lesson.service";
import {User} from "../login/user";


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

  }
/*
  onAnswer(user: User) {
    agreed ? this.agreed++ : this.disagreed++;
  }*/


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
