import {Injectable} from "@angular/core";
import {Http, Headers} from "@angular/http";
import {User} from "./user";
/**
 * Created by E-M on 4/27/2017.
 */



@Injectable()
export class UserService {

  private usersUrl = 'users';


  constructor(private http: Http) {
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

        localStorage.setItem("currentUser", JSON.stringify(response.json()));
        return response.json() as User;})
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

        localStorage.setItem("currentUser", JSON.stringify(response.json()));
        return response.json() as User;})
      .catch(this.handleError);
  }


  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
