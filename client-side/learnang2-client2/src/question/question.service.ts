import {Injectable} from "@angular/core";
import {Http, Headers} from "@angular/http";
import {Question} from "./question";
import {Observable} from "rxjs";
import {QuestionFeedback} from "./questionFeedback";
/**
 * Created by E-M on 4/17/2017.
 */



@Injectable()
export class QuestionService{

  private questionsUrl = 'api/lessons';

  constructor (private http: Http){}




//this should be according to user id --- different question fetching
  getQuestion(userid: number, lessonid: number): Promise<Question> {
    const url = `${this.questionsUrl}/${lessonid}/users/${userid}/question`;

 /*   let params: URLSearchParams = new URLSearchParams();
    params.set('userid', userid+"");*/
/*
    let requestOptions = new RequestOptions();
    requestOptions.search = params;*/



    return this.http.get(url)
      .toPromise()
      .then(response => {
        console.log(response.json());
        return response.json() as Question;
      })
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }



  private headers = new Headers({'Content-Type': 'application/json'});

  sendAnswer(questionid: number, lessonid: number, answerid: string, appliedDifficulty: number, userid: number ): Promise<QuestionFeedback> {

    const url = `${this.questionsUrl}/${lessonid}/question/answer`;

    console.log(questionid, answerid );
/*
    return this.http
      .post(url, JSON.stringify({questionId: questionid, answerId: answerid, userId: userid }), {headers: this.headers})
      .toPromise()
      .then(res => res.json())
      .catch(this.handleError);*/

    return this.http
      .post(url, {questionId: questionid, answerId: answerid, userId: userid, appliedDifficulty: appliedDifficulty}, {headers: this.headers})
      .toPromise()
      .then(response => {
        console.log(response);
        console.log(response.json());
        return response.json() as QuestionFeedback;})
      .catch(this.handleError);
  }

}
