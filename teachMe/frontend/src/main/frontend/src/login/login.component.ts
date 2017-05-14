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
  styleUrls: ['./login.component.css'],
  providers: [ UserService ]
})


export class LoginComponent implements OnInit {

  user: User;
  error: string;

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
      console.log("received");
      console.log(result);

      if(result.id == 0){
        this.error = "Sorry, but the credentials are not correct."
      }
      this.router.navigate(['/home']);
    });




}

}
