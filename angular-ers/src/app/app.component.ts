import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Emily & Kayma\'s Employment Reimbursement App';
  currUser: string = localStorage.getItem('currUser');



  
  
  
  
}
