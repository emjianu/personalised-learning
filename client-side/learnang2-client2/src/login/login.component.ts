import {Component, OnInit} from "@angular/core";
import {User} from "./user";
import {Router,ActivatedRoute} from "@angular/router";
import {UserService} from "./user.service";
/**
 * Created by E-M on 4/27/2017.
 */


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  //styleUrls: ['./home.component.css'],
  providers: [ UserService ]
})


export class LoginComponent implements OnInit {

  user: User;

  constructor (
    private router: Router,
    private userService: UserService,
    private route: ActivatedRoute,
    //private location: Location

  ){}


  ngOnInit(){
      this.user = new User();
  }

  login(): User {

    if (!this.user) { return; }
    this.userService.loginUser(this.user)
      .then( result =>{
      console.log("received")
      console.log(result)
      this.router.navigate(['/home']);
    });




}

}
