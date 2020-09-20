import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import { TaskServiceService } from '../task-service.service';
import { DatePipe } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private service:TaskServiceService,private rou:Router) { }
  userform:FormGroup;

 todaydate=new Date();
 x:number=Math.floor((Math.random()*10000)+1);
 
//  todaydate1=todaydate
  // valuedate;

  ngOnInit() {

    this.userform=new FormGroup(
      {
        firstName:new FormControl('',[Validators.required]),
        lastName:new FormControl('',[Validators.required]),
        gender:new FormControl(),
        email:new FormControl(),
        dob:new FormControl('',[Validators.required]),
        pwd:new FormControl('',[Validators.required]),
        confirmPwd:new FormControl('',[Validators.required]),
        regDate:new FormControl(),
        randomno:new FormControl()
    }
    );
  }

  register:boolean=false;
  code;
  // save()
  // {
  //   alert("register successfully ");
  //   this.service.saveRegisteredUser(this.userform.value).subscribe();
   

  // }

  ver:any;
  save()
  {
    //this.service.verify(this.userform.value).subscribe();
    alert("verifying your email...")
    this.service.verify(this.userform.value).subscribe(d=>{this.ver=d
    
      if(this.ver=="done")
      {
        this.register=true;
        alert("please enter your verification code")
        
      }
      else{
        alert("please check your mail id correct or not");
        this.register=false;
      }
    });
  }

  registersave()
  {
    if(this.x==this.code)
    {
      
      alert("registered successfully");
      this.service.saveRegisteredUser(this.userform.value).subscribe();
       this.code=" ";
    }
    else{
      alert("please check the Otp is correct or not");
    }
    
    
  }

  signin()
  {
    this.rou.navigate(['/login']);
    
  }

  
    
  
  
}
