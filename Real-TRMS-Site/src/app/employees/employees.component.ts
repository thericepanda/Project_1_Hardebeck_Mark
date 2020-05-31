import { Component, OnInit } from '@angular/core';
import { Employees} from '../EMPLOYEES';
import { EmployeesService } from '../employees.service';
import { FormsService } from '../forms.service';
import { Forms } from '../Forms';
import { Update } from '../Update';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

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
  
  constructor(private employeeservice: EmployeesService, private formsservice : FormsService) { }

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
    this.formsservice.getFormData().subscribe(res => this.formy = res)
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
      }
      console.log(this.form.time);
    })
      
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
  onClick2(){
    console.log(this.update.formID)
    this.formsservice.dirSupUpdateForm(this.update).subscribe();
  }
}