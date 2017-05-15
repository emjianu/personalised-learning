import {Component, OnInit} from "@angular/core";

import {Router, ActivatedRoute} from "@angular/router";
import {UserService} from "../login/user.service";
import {User} from "../login/user";

/**
 * Created by E-M on 4/27/2017.
 */


@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers: [UserService]
})


export class RegisterComponent implements OnInit {

  user: User;
  error: string;

  email: string;
  username: string;
  password: string;


  constructor(private router: Router,
              private userService: UserService,
              private route: ActivatedRoute,
              //private location: Location

  ) {
  }


  ngOnInit() {
    this.user = new User();

    this.email = '';
    this.username = '';
    this.password = '';
  }

  register(): User {

    if (!this.user) {
      return;
    }
    this.userService.registerUser(this.user)
      .then(result => {
        console.log("received");
        console.log(result);
        this.router.navigate(['/home']);
      }).catch(error => {
      this.error = error;
    });


  }

}
