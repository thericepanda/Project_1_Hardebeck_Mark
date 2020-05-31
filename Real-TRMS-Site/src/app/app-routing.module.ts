import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { EmployeesComponent } from './employees/employees.component';


const routes: Routes = [{
  path: 'login', component: LoginComponent 
},
{ path: '', redirectTo: '/login', pathMatch: 'full' },
{
  path: 'employees', component: EmployeesComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
