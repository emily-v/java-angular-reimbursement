import { Injectable } from '@angular/core';
import { Form } from 'src/app/models/Form';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FormService {

 public insertUrl = 'http://localhost:8080/ERS/FormServlet';
//  public insertUrl = 'http://localhost:8080/HiberDemo/FormServlet';
//  public insertUrl = 'http://localhost:8080/servletexam/FormServlet';
  
  constructor(private httpClient: HttpClient) { }
  
  public insertForm(form: Form){
  	return this.httpClient.post<Form>(this.insertUrl, JSON.stringify(form));
  }
  public updateForm(form: Form) {
 	return this.httpClient.post<Form>(this.insertUrl, JSON.stringify(form));
  }
  // shouldn't this take in an id instead of a form?
  public getAllUserForm(form: Form){
  	return this.httpClient.post<Form>(this.insertUrl, JSON.stringify(form));
  }
  
  getAllForms(): Observable<Array<Form>>{
  	return this.httpClient.get<Array<Form>>(this.insertUrl);
  }

} 