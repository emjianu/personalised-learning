/**
 * Created by E-M on 4/16/2017.
 */
import {Component, OnInit} from '@angular/core';
import {LessonService} from "../lesson/lesson.service";
import {Lesson} from "../lesson/lesson";



@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  //styleUrls: ['./home.component.css'],
  providers: [ LessonService ]
})
export class HomeComponent implements OnInit {
  title = 'app works!';

  lessons: Lesson[];
  errorMessage: string;
  isVisible: boolean;

  constructor(private lessonService: LessonService) {
  }


  ngOnInit() {
    this.getLessons();
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.isVisible = false;
  }

  getLessons() {
    this.lessonService.getAllLessons()
      .subscribe(
        lessons => this.lessons = lessons,
        error => this.errorMessage = <any>error);
    console.log(this.lessons)
  }



}
