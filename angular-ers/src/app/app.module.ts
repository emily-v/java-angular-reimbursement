import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
// import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { EmpHomeComponent } from './components/emp-home/emp-home.component';
import { NewExpComponent } from './components/new-exp/new-exp.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { EmpTableComponent } from './components/emp-home/emp-table/emp-table.component';
import { MgrHomeComponent } from './components/mgr-home/mgr-home.component';
import { MgrTableComponent } from './components/mgr-home/mgr-table/mgr-table.component';
import { DetailsComponent } from './components/details/details.component';
import { SuccessPageComponent } from './components/success-page/success-page.component';
import { CoreModule } from './services/core.module';
import { FilterButtonComponent } from './components/filter-button/filter-button.component';
import { MainComponent } from './components/main/main.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmpHomeComponent,
    NewExpComponent,
    NavbarComponent,
    EmpTableComponent,
    MgrHomeComponent,
    MgrTableComponent,
    DetailsComponent,
    SuccessPageComponent,
    FilterButtonComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    // NgbModule
    CoreModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
