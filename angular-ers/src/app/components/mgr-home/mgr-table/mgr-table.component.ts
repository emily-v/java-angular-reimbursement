import { Component, OnInit, Input } from '@angular/core';
// import { IExpense } from 'src/app/shared/interfaces';
import { SorterService } from 'src/app/services/sorter.service';
// import { Expense } from '../../new-exp/new-exp.component';
import { Form } from 'src/app/models/Form';
import { FormService } from 'src/app/services/form.service';

@Component({
  selector: 'app-mgr-table',
  templateUrl: './mgr-table.component.html',
  styleUrls: ['./mgr-table.component.css']
})
export class MgrTableComponent implements OnInit {
private form: Form;
  private _forms : Form[] = [];
    //  localStorage.setItem('currUser', JSON.stringify(this.user));

 currUser: string = localStorage.getItem('currUser');
  // empid: number = JSON.parse(this.currUser).id;
  email: string = JSON.parse(this.currUser).email;

  @Input() get forms(): Form[] {
    return this._forms;
  }

  setcurrForm(f: Form){ 
localStorage.setItem('currExp', JSON.stringify(f));
}

  set expenses(value: Form[]) {
    if (value) {
      this._forms = value;
    }  
  }

  // showExp:any[] = [];
  
  setFormData(data) {
    this._forms = data;
    // this.showExp = this._forms;
  }

  retrieveAllExp() {
    this.formService.getAllForms(this.form).subscribe( (data) => { this.setFormData(data); });
  }

  constructor(private sorterService: SorterService, private formService: FormService) { }

  ngOnInit() {
    // this.form = new Form();
    // this.form.status = 'manager';
    this.retrieveAllExp();
  }

  // filter(value: string) {
  //   let filtered = [];
  //   if (value === "Pending") {
  //     this.setFormData(this._expenses.filter((exp: IExpense) => {
  //       return exp.status === "pending";
  //     }));
  //     console.log("pending");
  //   } 
  //   else if (value === "Approved") {
  //     this.setFormData(this._expenses.filter((exp: IExpense) => {
  //       return exp.status === "approved";
  //     })); 
  //     console.log("approved"); 
  //   } 
  //   else if (value === "Denied") {
  //     this.setFormData(this._expenses.filter((exp: IExpense) => {
  //       return exp.status === "denied";
  //     }));
  //     console.log("denied");
  //   }
  //   else  {
  //     this.setFormData(this._expenses);
  //   } 
  //   // setTimeout(() => this.retrieveAllUserExp(), 3000);
  // }

  sort(prop: string) {
    this.sorterService.sort(this._forms, prop);
  }
}
