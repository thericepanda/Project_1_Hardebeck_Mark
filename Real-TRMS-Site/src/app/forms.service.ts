import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Forms } from './Forms';
import { Update } from './Update';
import { Messages } from './Messages';

@Injectable({
  providedIn: 'root'
})
export class FormsService {

  constructor(private httpclient: HttpClient) { }

    getFormData():Observable<Forms[]>{
      return this.httpclient.get<Forms[]>('http://localhost:8080/Real_TRMS_Project/forms')
    }

    addForm(form:Forms):Observable<any>{
      return this.httpclient.post<any>('http://localhost:8080/Real_TRMS_Project/forms', JSON.stringify(form));
    }

    dirSupUpdateForm(update:Update):Observable<any>{
      return this.httpclient.post<any>('http://localhost:8080/Real_TRMS_Project/employees', JSON.stringify(update));
    }

    addMessage(message:Messages):Observable<any>{
      return this.httpclient.post<any>('http://localhost:8080/Real_TRMS_Project/messages', JSON.stringify(message));
    }
}
