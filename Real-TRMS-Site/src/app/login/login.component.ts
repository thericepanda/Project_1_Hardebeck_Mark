import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Login } from '../Login';
import { Router } from '@angular/router';
import { EmployeesService } from '../employees.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private auth: AuthService, private router: Router, private employeeservice: EmployeesService) { }

  ngOnInit(): void {
  }
  login : Login = {
    username: "",
    password: ""
  }

  onClick(event){
    event.preventDefault();
    const target = event.target;
    const username = target.querySelector('#Username').value;
    const password = target.querySelector('#Password').value;
    this.login.username = username;
    this.login.password = password;
    this.auth.getUserDetails(this.login).subscribe(res=> {
      if (res.empID == 41){
        window.alert('Invalid credentials')
      } else{
        this.employeeservice.setIndividualEmployee(res);
        this.router.navigate(['employees']);
      }
    });
  }
}
