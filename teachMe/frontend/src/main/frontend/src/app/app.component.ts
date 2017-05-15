import {Component, OnInit} from '@angular/core';
import {LessonService} from "../lesson/lesson.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [LessonService]

})
export class AppComponent implements OnInit {
  title = 'app works!';


  isVisible: boolean;


  ngOnInit() {
    this.isVisible = false;

    console.log(this.isVisible);
  }


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
