import { Component, OnInit } from '@angular/core';
// import { AuthService } from 'src/app/services/auth.service';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from 'src/app/models/User';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  user: User;

  constructor(//private authService: AuthService,
              private router: Router,
              private route: ActivatedRoute,
              private userservice: UserServiceService) { 
             
              
              
              }

  ngOnInit() {
  }

  loginUser() {
  	this.user = new User();
  	this.user.email = this.username;
  	this.user.password = this.password;
  	this.userservice.sendUser(this.user).subscribe( (data) => {   this.setUserData(data) });
  }

  setUserData(data){
    if(data == null){
        alert('Invalid login attempt. Please try again.');
    } else{
      this.user = data;
      localStorage.setItem('currUser', JSON.stringify(this.user)); 
      // this.router.navigate(['mgr-home']);
      if(this.user.role === 'manager'){
        this.router.navigate(['mgr-home']);
      } else {
        this.router.navigate(['emp-home']);
      }
    }
  }
  
  // loginSubmit() {
  //   console.log('oh hello');
  //   this.authService.authenticate(this.username, this.password, this.successful, this.failed);
  //   console.log(this.authService.authenticate);
  // }

  // successful() {
  //   console.log("login successful");
  //   return true;
  // }
  // failed() {
  //   console.log("login failed");
  //   return true;
  // }

}
