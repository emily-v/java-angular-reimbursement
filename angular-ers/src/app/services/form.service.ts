import { Injectable } from '@angular/core';
import { Form } from 'src/app/models/Form';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FormService {

//  public insertUrl = 'http://localhost:8080/HiberDemo/FormServlet';
 public insertUrl = 'http://localhost:8080/servletexam/FormServlet';
  
  constructor(private httpClient: HttpClient) { }
  
  public insertForm(form: Form){
  	return this.httpClient.post<Form>(this.insertUrl, JSON.stringify(form));
  }
  public updateForm(form: Form) {
 	return this.httpClient.post<Form>(this.insertUrl, JSON.stringify(form));
  }
  public getAllUserForm(form: Form){
  	return this.httpClient.post<Form>(this.insertUrl, JSON.stringify(form));
  }
  
  getAllManagerForm(form: Form){
   	console.log(JSON.stringify(form));
  	return this.httpClient.post<Form>(this.insertUrl, JSON.stringify(form));
  }

} 