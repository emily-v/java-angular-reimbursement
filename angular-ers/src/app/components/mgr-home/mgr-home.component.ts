import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
// import { IExpense } from 'src/app/shared/interfaces';


@Component({
  selector: 'app-mgr-home',
  templateUrl: './mgr-home.component.html',
  styleUrls: ['./mgr-home.component.css']
})
export class MgrHomeComponent implements OnInit {
  
  // requests: IExpense[];
  currUser: string = localStorage.getItem('currUser');
  firstname: string = JSON.parse(this.currUser).firstname;

  constructor( private dataService: DataService) { }

 ngOnInit() { 
 //   this.dataService.getExpenses()
   //   .subscribe((expenses: IExpense[]) => this.requests = expenses);

  }

}
