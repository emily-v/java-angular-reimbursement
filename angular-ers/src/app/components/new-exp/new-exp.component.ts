import { Component, OnInit } from '@angular/core';
// import { IExpense } from 'src/app/shared/interfaces';
import { Router } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
import { Form } from 'src/app/models/Form';
import { FormService } from 'src/app/services/form.service';


@Component({
  selector: 'app-new-exp',
  templateUrl: './new-exp.component.html',
  styleUrls: ['./new-exp.component.css']
})
export class NewExpComponent implements OnInit {
  currUser: string = localStorage.getItem('currUser');
  email: string = JSON.parse(this.currUser).email;
  expense: Expense;

  form: Form;
 
  constructor(private router: Router, private formservice: FormService) {
  
   }


  ngOnInit() {
    this.form = new Form();
    // this.expense = new Expense(1, this.getTodaysDate(),"2019-01-15","email@email.com","pending",122.22,null,1, null)
  } 

  getTodaysDate() {
    let today = new Date();
    let date = today.getFullYear() + '-' + (today.getMonth()+1) + '-' + today.getDate();
    return date;
  }

 saveExpense() {
    // this.form = new Form();
    // this.form.submitdate = this.getTodaysDate();
    // this.form.transdate = this.expense.transDate;
    // this.form.status = 'pending';
    // this.form.expType =this.expense.expType ;
    // this.form.amount = this.expense.amount;
    // this.form.empid = this.email;
    // this.form.merchant = this.expense.merchant;

    // this.formservice.insertForm(this.form).subscribe();
    // this.router.navigate(['/success-page']);
  }
  
  

}
export class Expense {
  // transDate: String;
  // expType: String;
  // amount: number;
  // merchant: String;


   constructor(expId: number,
     submitDate: string,
     transDate: string,
     empid: string,
     expType: number,
     amount: number,
     merchant: string,
     status: number,
     resolveDate: string){
    
     }

}