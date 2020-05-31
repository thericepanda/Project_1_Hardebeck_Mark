import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from './Login';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  getUserDetails(login:Login): Observable<any>{
    
    return this.http.post<any>('http://localhost:8080/Real_TRMS_Project/login',JSON.stringify(login));
  }
}