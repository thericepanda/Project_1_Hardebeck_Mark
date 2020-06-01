import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employees } from './Employees';
import { Observable } from 'rxjs';
import { Messages } from './Messages';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  employee: Employees = {
    empID: 3,
    username: 'a',
    password: 'p',
    firstName: 'c',
    lastName: 'd',
    email: 'e',
    type: 'Benefits Coordinator',
    amtAvail: 1000,
    department: 'Sales',
    branch: 'California'
  };

 
  constructor(private httpclient: HttpClient) { }

    getEmployeesInfo():Observable<Employees[]>{
      return this.httpclient.get<Employees[]>('http://localhost:8080/Real_TRMS_Project/employees');
    }

    getMessages():Observable<Messages[]>{
      return this.httpclient.get<Messages[]>('http://localhost:8080/Real_TRMS_Project/messages');
    }

    setIndividualEmployee(employee):Observable<Employees>{
      return this.employee = employee;
    }

    getIndividualEmployee(){
      return this.employee;
    }
}
