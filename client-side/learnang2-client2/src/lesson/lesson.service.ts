/**
 * Created by E-M on 4/10/2017.
 */
import { Injectable }              from '@angular/core';
import { Http, Response }          from '@angular/http';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Lesson } from './lesson';
import {Observable} from "rxjs";

@Injectable()
export class LessonService {
  private lessonsUrl = 'api/lessons';  // URL to web API

  constructor (private http: Http) {}

  getLesson(id: number): Promise<Lesson> {
    const url = `${this.lessonsUrl}/${id}`;

    return this.http.get(url)
      .toPromise()
      .then(response => {
        console.log(response.json());
        return response.json() as Lesson;
      })
      .catch(this.handleError);
  }


  getAllLessons(): Observable<Lesson[]> {
    const url = `${this.lessonsUrl}`;

    return this.http.get(url)
      .map(response => {
        console.log(response.json());
        return response.json() as Lesson[];
      })
      .catch(this.handleError);
  }



  private extractData(res: Response) {
    let body = res.json();
    return body.data || { };
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
