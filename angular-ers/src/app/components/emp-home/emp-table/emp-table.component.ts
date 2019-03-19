import { Component, OnInit, Input } from '@angular/core';

import { IExpense } from 'src/app/shared/interfaces';
import { SorterService } from 'src/app/services/sorter.service';
import { Expense } from '../../new-exp/new-exp.component';
import { Form } from 'src/app/models/Form';
import { FormService } from 'src/app/services/form.service';

@Component({
  selector: 'app-emp-table',
  templateUrl: './emp-table.component.html',
  styleUrls: ['./emp-table.component.css']
})
export class EmpTableComponent implements OnInit {
private expense: Expense;
  private _expenses: IExpense[] = [];

  currUser: string = localStorage.getItem('currUser');
  // email: string = JSON.parse(this.currUser).email;
  id: number = JSON.parse(this.currUser).empid;
  private form: Form;
  
  @Input() get expenses(): IExpense[] {
   return this._expenses;
 }

  set expenses(value: IExpense[]) {
    if (value) {
      this._expenses = value;
    }
  }
 
  showExp:any[] = [];
  
  setFormData(data) {
    this._expenses = data;
    this.showExp = this._expenses;
  }

  retrieveAllUserExp() {
    this.formService.getAllUserForm(this.form).subscribe( (data) => { this.setFormData(data); });
  }

  constructor(private sorterService: SorterService, private formService: FormService) { }

  ngOnInit() {
    // this.expense = new Expense;
     this.form = new Form();
    this.form.empid = this.id;
    this.retrieveAllUserExp();
  }

  filter(value: string) {
    let filtered = [];
    if (value === "Pending") {
      this.setFormData(this._expenses.filter((exp: IExpense) => {
        return exp.status === "pending";
      }));
      console.log("pending");
    } 
    else if (value === "Approved") {
      this.setFormData(this._expenses.filter((exp: IExpense) => {
        return exp.status === "approved";
      })); 
      console.log("approved"); 
    } 
    else if (value === "Denied") {
      this.setFormData(this._expenses.filter((exp: IExpense) => {
        return exp.status === "denied";
      }));
      console.log("denied");
    }
    else  {
      this.setFormData(this._expenses);
    } 
    // setTimeout(() => this.retrieveAllUserExp(), 3000);
  }

  sort(prop: string) {
    this.sorterService.sort(this.showExp, prop);
  }


}
