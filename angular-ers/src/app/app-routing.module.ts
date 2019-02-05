import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { EmpHomeComponent } from './components/emp-home/emp-home.component';
import { NewExpComponent } from './components/new-exp/new-exp.component';
import { MgrHomeComponent } from './components/mgr-home/mgr-home.component';
import { DetailsComponent } from './components/details/details.component';
import { SuccessPageComponent } from './components/success-page/success-page.component';
import { UserGuardService } from './services/user-guard-service';

const routes: Routes = [
  {path: '', component: LoginComponent , 
    canActivate: [UserGuardService]},
  { path: 'login', component: LoginComponent },
  { path: 'emp-home', component: EmpHomeComponent, canActivate: [UserGuardService] },
  { path: 'new-exp', component: NewExpComponent, canActivate: [UserGuardService] },
  { path: 'mgr-home', component: MgrHomeComponent, canActivate: [UserGuardService] },
  { path: 'details/:id', component: DetailsComponent, canActivate: [UserGuardService] },
  { path: 'success-page', component: SuccessPageComponent, canActivate: [UserGuardService] }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
