import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  isUserLoggedIn:boolean = false;
  url = "http://localhost:8090/User";

  loginCheck(data: Login){
    this.isUserLoggedIn=true;
    return this.httpClient.post<any>(this.url + "/login", data);
  }

}
