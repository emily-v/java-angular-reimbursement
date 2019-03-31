import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { IExpense } from 'src/app/shared/interfaces';
import { Form } from 'src/app/models/Form';
import { FormService } from 'src/app/services/form.service';
import { Expense } from '../new-exp/new-exp.component';

@Component({
  selector: 'app-emp-home',
  templateUrl: './emp-home.component.html',
  styleUrls: ['./emp-home.component.css']
})
export class EmpHomeComponent implements OnInit {
 currUser: string = localStorage.getItem('currUser');
  email: string = JSON.parse(this.currUser).email;
 firstname: string = JSON.parse(this.currUser).firstname;
  requests: Form[];

  form: Form;
  formArr : Form;
    constructor( private dataService: DataService, private formservice: FormService) {

  
  
   }

   

  ngOnInit() {
    // this.dataService.getExpenses()
    // .subscribe((expenses: IExpense[]) => this.requests = expenses);
      
  }

}
