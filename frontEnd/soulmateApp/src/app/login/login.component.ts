import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../login';
import { LoginService } from '../login.service';
// import { LoginService } from '../login.service';
// import { LoginClass } from '../login-class';
// import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isClicked:boolean=false;
  
  loginform:any;
  logindata: Login | any;
  
  constructor(private router: Router, private loginService: LoginService) {
    
    this.loginform={
      emailId:'',
      password:''
    }
   }

  ngOnInit(): void {
  }

  onSubmit(data:any){
    this.isClicked=true;
    // this.loginService.loggedin=true;
    console.log(data);
    console.log("on Submit is being called");
    
    this.logindata = data; 
    console.log(this.logindata);
    this.loginService.loginCheck(this.logindata).subscribe(
      a => {
        // this.router.navigateByUrl("/dashboard");
        window.localStorage.setItem('token', a.token);
        window.localStorage.setItem('userEmail',this.logindata.emailId); 
        alert("login success....welcome");
        this.router.navigateByUrl("/search");
      },
      error => {
        console.log(error);
        alert("login failed");
      });
}
}
