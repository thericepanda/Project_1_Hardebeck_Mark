import { Component, OnInit } from '@angular/core';
import { Employees} from '../EMPLOYEES';
import { EmployeesService } from '../employees.service';
import { FormsService } from '../forms.service';
import { Forms } from '../Forms';
import { Update } from '../Update';
import { Messages } from '../Messages';
import { Router } from '@angular/router';
import { Approved } from '../Approved';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  constructor(private employeeservice: EmployeesService, private formsservice : FormsService, private router: Router) { }

  ngOnInit(): void {
    //this.getAllEmployees();
    this.onloading();
  }

  // getAllEmployees(){
  //   this.employeeservice.getEmployeesInfo().subscribe(returnEmployees => this.employees = returnEmployees);
  // }
  onloading(){
    this.employeeI = this.employeeservice.getIndividualEmployee();
    this.form.empID = this.employeeI.empID ;
    this.form.firstName = this.employeeI.firstName;
    this.form.lastName = this.employeeI.lastName;
    this.form.email =this.employeeI.email;
    this.form.type = this.employeeI.type;
    this.form.empAvailAmt = this.employeeI.amtAvail;
    this.form.department = this.employeeI.department;
    this.form.branch = this.employeeI.branch;
    this.formsservice.getFormData().subscribe(res => this.formy = res);
    this.employeeservice.getMessages().subscribe(res => this.messages = res);
  }

  onClick0(){
    this.router.navigate(['login']);
  }
  employees: Employees[];
  employeeI: Employees = {
    empID: 400,
    username: 'a',
    password: 'p',
    firstName: 'c',
    lastName: 'd',
    email: 'e',
    type: 'Employee',
    amtAvail: 1000,
    department: '',
    branch: ''
  };
  messages: Messages[];
  formy: Forms[];
  forms: Forms[];

  form : Forms = {
    formID: null,
    empID : this.employeeI.empID,
    firstName : this.employeeI.firstName,
    lastName : this.employeeI.lastName,
    email : this.employeeI.lastName,
    type : this.employeeI.type,
    eventType : "",
    time : null,
    eventTime: null,
    location : "",
    description : "",
    cost : null,
    rmbrsmntAmt: null,
    empAvailAmt: null,
    gradeFormat : null,
    justification : "",
    directSupervisorApproval: "PENDING",
    departmentHeadApproval: "PENDING",
    benCoApproval: "PENDING",
    rejectionReason: "",
    department: "",
    branch: ""
  }
  
  
  


  onClick(){
    this.onCalculate(this.form.eventType,this.form.cost);
    this.employeeI.amtAvail = this.employeeI.amtAvail - this.reimbursement;
    if(this.form.benCoApproval == 'Percentage Grading'){
      this.form.gradeFormat = 1;
    }else if(this.form.benCoApproval == 'Letter Grading'){
      this.form.gradeFormat = 2;
    }else if(this.form.benCoApproval == 'Mastery Grading'){
      this.form.gradeFormat = 3;
    }else if(this.form.benCoApproval == 'Pass/Fail'){
      this.form.gradeFormat = 4;
    }else if(this.form.benCoApproval == 'Standards Grading'){
      this.form.gradeFormat = 5;
    }
    this.formsservice.addForm(this.form).subscribe(res => {
      if(res == "Alert"){
        window.alert('You must enter a week later')
        this.employeeI.amtAvail = 1000;
      }
    })
    
    
    let newDate = new Date(this.form.eventTime);
    var x = Date.now()
    if((newDate.getTime() - x)<1209600000){ //2 weeks
      console.log(newDate.getTime());
      console.log("nani");
      this.message.empID = this.form.empID;
      console.log(this.message.empID);
      this.message.urgent = 1;
      this.formsservice.addMessage(this.message).subscribe();
    }
      
    function reset(){
      window.alert("Your form has been sumbitted");
    }
    setTimeout(reset,1000);
    this.form.formID= null;
      this.form.empID = this.employeeI.empID;
      this.form.firstName = this.employeeI.firstName;
      this.form.lastName = this.employeeI.lastName;
      this.form.email = this.employeeI.lastName;
      this.form.type = this.employeeI.type;
      this.form.eventType = "";
      this.form.time = null;
      this.form.eventTime= null;
      this.form.location = "";
      this.form.description = "";
      this.form.cost = null;
      this.form.rmbrsmntAmt= null;
      this.form.empAvailAmt= this.employeeI.amtAvail;
      this.form.gradeFormat = null;
      this.form.justification = "";
      this.form.directSupervisorApproval= "";
      this.form.departmentHeadApproval= "";
      this.form.benCoApproval= "";
      this.form.rejectionReason= "";
      this.formsservice.getFormData().subscribe(res => this.formy = res);
  }

  isHidden = true;
  reimbursement=0;
  onCalculate(type,cost){
    this.isHidden = false;
    if(cost!=null){
      if (type == "Certification"){
        if(cost>this.employeeI.amtAvail){
          this.reimbursement = this.employeeI.amtAvail;
          this.form.rmbrsmntAmt = this.reimbursement;
          return this.reimbursement;
        }else{
          this.reimbursement = cost;
          this.form.rmbrsmntAmt = this.reimbursement;
          return this.reimbursement;
        }
      }
      else if(type == "Technical Training"){
        if(cost*.9>this.employeeI.amtAvail){
          this.reimbursement = this.employeeI.amtAvail;
          this.form.rmbrsmntAmt = this.reimbursement;
          return this.reimbursement;
        }else{
          this.reimbursement = cost*.9;
          this.form.rmbrsmntAmt = this.reimbursement;
          return this.reimbursement;
        }
      }
      else if(type == "University Courses"){
        if(cost*.8>this.employeeI.amtAvail){
          this.reimbursement = this.employeeI.amtAvail;
          this.form.rmbrsmntAmt = this.reimbursement;
          return this.reimbursement;
        }else{
          this.reimbursement = cost*.8;
          this.form.rmbrsmntAmt = this.reimbursement;
          return this.reimbursement;
        }
      }
      else if(type == "Certification Preparation Classes"){
        if(cost*.75>this.employeeI.amtAvail){
          this.reimbursement = this.employeeI.amtAvail;
          this.form.rmbrsmntAmt = this.reimbursement;
          return this.reimbursement;
        }else{
          this.reimbursement = cost*.75;
          this.form.rmbrsmntAmt = this.reimbursement;
          return this.reimbursement;
        }
      }
      else if(type == "Seminar"){
        if(cost*.6>this.employeeI.amtAvail){
          this.reimbursement = this.employeeI.amtAvail
          this.form.rmbrsmntAmt = this.reimbursement;
        }else{
          this.reimbursement = cost*.6;
          this.form.rmbrsmntAmt = this.reimbursement;
          return this.reimbursement;
        }
      }
      else if(type == "Other"){
        if(cost*.3>this.employeeI.amtAvail){
          this.reimbursement = this.employeeI.amtAvail
          this.form.rmbrsmntAmt = this.reimbursement;
        }else{
          this.reimbursement = cost*.3;
          this.form.rmbrsmntAmt = this.reimbursement;
          return this.reimbursement
        }
      }
      else{
        window.alert("You must select an event type to calculate your reimbursement amount")
      }
    }else{
      window.alert("You must enter a cost to calculate your reimbursement amount")
    }
  }

  update:Update = {
    formID: null,
    directSupervisorApproval: "PENDING",
    departmentHeadApproval: "PENDING",
    benCoApproval: "PENDING",
    rejectionReason: ""
  }

  message:Messages = {
    formID: null,
    empID: null,
    oldAmt:null,
    newAmt: null,
    urgent: null,
    response: null,
    additionalInfo: ""
  }
  onClick2(){
    this.formsservice.dirSupUpdateForm(this.update).subscribe();
  }

  onClick3(){
    this.message.response = 1;
    this.formsservice.addMessage(this.message).subscribe();
  }

  onClick4(){
    this.message.response = 2;
    this.message.empID = this.employeeI.empID;
    this.formsservice.addMessage(this.message).subscribe();
  }

  approved:Approved = {
    formID:null,
    empID:null,
    image:null
  }
  onClick5(){
    console.log(this.approved.image);
  }
}