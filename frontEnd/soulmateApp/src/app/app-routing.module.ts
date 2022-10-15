import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardGuard } from './dashboard.guard';
import { FilterComponent } from './filter/filter.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { RegisterGuard } from './register.guard';
import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserdetailsGuard } from './userdetails.guard';

const routes: Routes = [
  {path:'',component:HomepageComponent},
  {path:'home',component:HomepageComponent},
  { path: 'search', component: SearchComponent, 
  canActivate:[DashboardGuard],
  canActivateChild:[UserdetailsGuard],
  children:[
    {  path: 'user', component: UserDetailsComponent}
  ]},
  { path: 'register', component: RegisterComponent, canDeactivate:[RegisterGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'filter', component: FilterComponent}
//  , canActivateChild:[UserdetailsGuard]}

  // , canActivate:[UserdetailsGuard]
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
