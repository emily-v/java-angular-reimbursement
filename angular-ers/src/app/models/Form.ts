export class Form {
public formid: number;
public submitdate: String;
public transdate: String;
public expType: String;
public amount: number;
public merchant: String;
public status: String;
public resolvedate: String;
public empid: String;
	
public Form(formid: number, submitdate: String, transdate: String, expType: String, amount: number, //amount: float, 
    merchant: String, status: String, resolvedate: String, empid: String){
this.formid = formid;
this.submitdate = submitdate;
this.transdate = transdate;
this.expType = expType;
this.amount = amount;
this.merchant = merchant;
this.status = status;
this.resolvedate = resolvedate;
this.empid = empid;
}
}