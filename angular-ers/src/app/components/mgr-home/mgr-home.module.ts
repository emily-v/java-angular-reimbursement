import { CommonModule } from '@angular/common'; // only import BrowserModule in parent module
// import CommonModule in child modules
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { MgrHomeComponent } from './mgr-home.component';
import { MgrTableComponent } from './mgr-table/mgr-table.component';

@NgModule({
  declarations: [
    MgrHomeComponent,
    MgrTableComponent
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

export class MgrHomeModule { }