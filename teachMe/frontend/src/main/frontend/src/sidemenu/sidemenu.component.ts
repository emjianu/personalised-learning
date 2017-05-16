/**
 * Created by E-M on 5/13/2017.
 */


/**
 * Created by E-M on 4/16/2017.
 */
import {Component, OnInit} from '@angular/core';
import {LessonService} from "../lesson/lesson.service";
import {Lesson} from "../lesson/lesson";
import {UserService} from "../login/user.service";
import {User} from "../login/user";
import {ActivatedRoute, Params, Router} from "@angular/router";


@Component({
  selector: 'info',
  templateUrl: './sidemenu.component.html',
  //styleUrls: ['./home.component.css'],
  providers: [ UserService ]
})
export class SideMenuComponent implements OnInit {
  title = 'app works!';

  user: User;
  errorMessage: string;

  constructor(private router: Router,
              private userService: UserService,
              private route: ActivatedRoute) {
  };

  loggedIn(): boolean{
    this.user = JSON.parse(sessionStorage.getItem('currentUser'));

    if(this.user != null){
      return true;
    } else {
      return false;
    }
  }


  ngOnInit() {

    console.log("init side menu");
    this.user = JSON.parse(sessionStorage.getItem('currentUser'));

    console.log(this.user);
  }


  logout(): void {
    sessionStorage.removeItem('currentUser');
    this.router.navigate(['/']);
  }


}
