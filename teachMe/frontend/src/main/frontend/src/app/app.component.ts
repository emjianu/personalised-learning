import {Component, OnInit} from '@angular/core';
import {LessonService} from "../lesson/lesson.service";
import {Lesson} from "../lesson/lesson";



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ LessonService ]
})
export class AppComponent {
  title = 'app works!';
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
