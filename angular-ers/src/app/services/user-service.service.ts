import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from 'src/app/models/User';

@Injectable({
  providedIn: 'root'
})

export class UserServiceService {
 public url = 'http://localhost:8080/ERS/UserServlet'; 
//  public url = 'http://localhost:8080/HiberDemo/UserServlet';
  // public url = 'http://localhost:8080/servletexam/UserServlet';
  constructor(private httpClient: HttpClient) { }
  
  public sendUser(user: User){
  	return this.httpClient.post<User>(this.url, JSON.stringify(user));
  }
 
}
