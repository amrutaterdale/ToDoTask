import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
// import { from } from 'rxjs';
import { LoginComponent } from './login/login.component';
import { Routes, RouterModule } from '@angular/router';
import { AlltaskComponent } from './alltask/alltask.component';
import { AdmincompComponent } from './admincomp/admincomp.component';
import { GuardComponent } from './guard/guard.component';
import { ReportComponent } from './report/report.component';
import { CountComponent } from './count/count.component';


const routes:Routes=[
  {path:'',redirectTo:'/login',pathMatch:"full"},
  {path:'sign',component:SignupComponent},
  {path:'login',component:LoginComponent},
  {path:'task',component:AlltaskComponent},
  {path:'admin',component:AdmincompComponent},
  {path:'report',component:ReportComponent},
  {path:'chart',component:CountComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    AlltaskComponent,
    AdmincompComponent,
    GuardComponent,
    ReportComponent,
    CountComponent
  ],
  imports: [
    BrowserModule,FormsModule,ReactiveFormsModule,HttpClientModule,
    AppRoutingModule,RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
