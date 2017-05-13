/**
 * Created by E-M on 4/9/2017.
 */
import {Component, OnInit, Input} from '@angular/core';

import { Lesson } from './lesson';
import { LessonService } from "./lesson.service";
import { ActivatedRoute, Params } from "@angular/router";

import { Location } from '@angular/common';

import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'lesson',
 /* template: '<h1>{{lesson.title}}</h1>',*/
  templateUrl: './lesson.component.html',
  styleUrls: ['./lesson.component.css'],
  providers: [ LessonService ]
})
export class LessonComponent implements OnInit {

  errorMsg: string;
  lesson: Lesson;

  constructor (
    private lessonService: LessonService,
    private route: ActivatedRoute,
    private location: Location
  ){}

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => {
      console.log(params)
      return this.lessonService.getLesson(+params['id']);

    })
      .subscribe(lesson => {
        console.log(lesson)
        console.log(lesson.title)
        this.lesson = lesson;
        console.log(this.lesson.title)
      });
  }


}
