import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Register } from './register';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor( private httpClient:HttpClient) { }

  file:any;
  isUserRegistered:boolean=false;
  url: string = "http://localhost:8084/UserInfo";
  
  registerUser(data: Register, emailId: String) {
    console.log("register user is working");
    this.file= data.picture;
    this.isUserRegistered=true;
    this.httpClient.post<any>(this.url + "/register", data);
    this.httpClient.post<any>(this.url + "/registerImage/"+`${emailId}`, this.file);
    
    
  }
  
  // registerImage(picture: ){

  //   console.log(data);
    
  // }

}
