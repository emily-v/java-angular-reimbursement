export class User {
public id: number;
public email: String ;
public password: String ;
public firstname: String ;
public lastname: String ;
public role: boolean;

public User(id: number, email: String, password: String, firstname: String, lastname: String, role: boolean){
this.id = id;
this.email = email;
this.password = password;
this.firstname = firstname;
this.lastname = lastname;
this.role = role;
}
}