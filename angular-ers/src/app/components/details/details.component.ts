import { Component, OnInit } from '@angular/core';
import { IExpense } from 'src/app/shared/interfaces';
import { DataService } from 'src/app/services/data.service';
import { ActivatedRoute } from '@angular/router';
import { FormService } from 'src/app/services/form.service';
import { Form } from 'src/app/models/Form';


@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  expense: IExpense; 
  
currExp: string = localStorage.getItem('currExp');
  formid: number = JSON.parse(this.currExp).formid;
  empid: string = JSON.parse(this.currExp).empid;
  submitdate: string = JSON.parse(this.currExp).submitdate;
  transdate: string = JSON.parse(this.currExp).transdate;
  amount: string = JSON.parse(this.currExp).amount;
  type: string = JSON.parse(this.currExp).expType;
  merchant: string = JSON.parse(this.currExp).merchant;
  status: string = JSON.parse(this.currExp).status;
  resolvedate: string = JSON.parse(this.currExp).resolvedate;

  constructor(private dataService: DataService,
                private route: ActivatedRoute,
                private formService: FormService) { }


  ngOnInit() {
    let id = +this.route.snapshot.paramMap.get('id');
  }
 

  getTodaysDate() {
    let today = new Date();
    let date = today.getFullYear() + '-' + (today.getMonth()+1) + '-' + today.getDate();
    return date;
  }

  form: Form;

  updateForm(f: string) {
  this.form = new Form();
  this.form.status = f;
  this.form.formid = this.formid;
  this.form.resolvedate = this.getTodaysDate();
 
  this.formService.updateForm(this.form).subscribe();
  localStorage.removeItem('currExp');
  }

  clearCurrExp() {
    localStorage.removeItem('currExp');
  }

  getAllUserForm() {
  this.formService.getAllUserForm(this.form).subscribe();
  	} 

}
