import { CommonModule } from '@angular/common'; // only import BrowserModule in parent module
// import CommonModule in child modules
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { EmpHomeComponent } from './emp-home.component';
import { EmpTableComponent } from './emp-table/emp-table.component';


@NgModule({
  declarations: [
    EmpHomeComponent,
    EmpTableComponent
  ],
  imports: [
    CommonModule,
    //SharedModule,
    FormsModule,
    // CustomersRoutingModule
  ],
  providers: [],
//   exports: [ CustomersComponent ] // will be changing this later
})

export class EmpHomeModule { }