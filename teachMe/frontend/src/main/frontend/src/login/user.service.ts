import {Injectable} from "@angular/core";
import {Http, Headers} from "@angular/http";
import {User} from "./user";
import {RankService} from "../rank/rank.service";
import {QuestionService} from "../question/question.service";
/**
 * Created by E-M on 4/27/2017.
 */



@Injectable()
export class UserService {

  private usersUrl = 'users';

  user: User;


  constructor(private http: Http,
  private rankService: RankService,
  private questionService: QuestionService) {
  }

  private headers = new Headers({'Content-Type': 'application/json'});

  loginUser(user: User): Promise<User> {

    const url = `/learn/login`;

    console.log(user);

    return this.http
      .post(url, JSON.stringify({username: user.username, password: user.password}), {headers: this.headers})
      .toPromise()
      .then(response => {
        console.log(response.json());

        this.user = response.json() as User;

        this.user = this.rankService.setRank(this.user);
        this.user = this.questionService.getXptilNext(this.user);

        console.log(this.user.rank);

        sessionStorage.setItem("currentUser", JSON.stringify(this.user));
        //sessionStorage.setItem("currentUser", JSON.stringify(response.json()));
        return this.user;})
      .catch(this.handleError);
  }



  updateUser(id: number): Promise<User> {
    const url = `/learn/users/${id}`;

    return this.http.get(url)
      .toPromise()
      .then(response => {
        console.log(response.json());
        return response.json() as User;
      })
      .catch(this.handleError);
  }


  registerUser(user: User): Promise<User> {

    const url = `${this.usersUrl}/register`;

    console.log(user);

    return this.http
      .post(url, JSON.stringify({email: user.email, username: user.username, password: user.password}), {headers: this.headers})
      .toPromise()
      .then(response => {
        console.log(response.json());

        this.user = response.json() as User;
        this.user = this.rankService.setRank(this.user);

        this.user = this.questionService.getXptilNext(this.user);

        if(this.user.id != 0){
          sessionStorage.setItem("currentUser", JSON.stringify(this.user));
        }

        return response.json() as User;})
      .catch(this.handleError);
  }


  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
