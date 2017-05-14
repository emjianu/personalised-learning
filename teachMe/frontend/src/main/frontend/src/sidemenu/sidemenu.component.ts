
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



@Component({
  selector: 'info',
  templateUrl: './sidemenu.component.html',
  //styleUrls: ['./home.component.css'],
/*  providers: [ UserService ]*/
})
export class SideMenuComponent implements OnInit {
  title = 'app works!';

  user: User;
  errorMessage: string;



  ngOnInit() {

    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }




}
