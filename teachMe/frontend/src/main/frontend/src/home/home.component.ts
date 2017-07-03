/**
 * Created by E-M on 4/16/2017.
 */
import {Component, OnInit} from '@angular/core';
import {LessonService} from "../lesson/lesson.service";
import {Lesson} from "../lesson/lesson";
import {RankService} from "../rank/rank.service";



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
  clicked: boolean;

  targetId: string;

  constructor(private lessonService: LessonService,
              private rankService: RankService) {
  }



  ngOnInit() {
    this.getLessons();
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));

    this.isVisible = false;
    this.clicked = false;
  }

  getLessons() {
    this.lessonService.getAllLessons()
      .subscribe(
        lessons => this.lessons = lessons,
        error => this.errorMessage = <any>error);
    console.log(this.lessons)
  }

  handleClick(id: string) {
   this.clicked = !this.clicked;
   this.targetId = id;
  }



}
