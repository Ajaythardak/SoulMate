import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanDeactivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { RegisterService } from './register.service';
import { RegisterComponent } from './register/register.component';

@Injectable({
  providedIn: 'root'
})
export class RegisterGuard implements CanDeactivate<unknown> {

constructor(private router: Router,private registerService: RegisterService){

}

  canDeactivate(
    component: RegisterComponent,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState?: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {



      if(this.registerService.isUserRegistered){
        return true;
      } 
      else if(component.registerForm.dirty){
        window.alert("you have some unsaved data on this page.")
        
        if(window.confirm("Are you still want to leave this page.?")){
          return true;
        }
        return false;
      }
      else
        return true;
  }
  
}
