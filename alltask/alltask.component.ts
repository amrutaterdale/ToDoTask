import { Component, OnInit } from '@angular/core';
import { TaskServiceService } from '../task-service.service';
import { Router } from '@angular/router';
import { FormGroup,FormControl } from '@angular/forms';
// import { SSL_OP_PKCS1_CHECK_1 } from 'constants';

@Component({
  selector: 'app-alltask',
  templateUrl: './alltask.component.html',
  styleUrls: ['./alltask.component.css']
})
export class AlltaskComponent implements OnInit {

  taskdata:any=[];
 add:boolean =true;

  constructor(private ser:TaskServiceService,private rou:Router) { 
    
  }

  userform:FormGroup;

  ngOnInit() {
    this.ser.taskview().subscribe(s=>this.taskdata=s);

    
    
  }

  retrieve()
  {
     this.ser.taskview().subscribe(d=>this.taskdata=d);
  }

  checked:boolean;
  //todaydate=new Date();
   status:string;
  data1:any={};
  data2:any={};
  tname;
  tdesc;
  taskdate=new Date();
  //val;

  // tempobj1:any={};
  changeStatus(i)
  {
    
    // this.tempobj.chkbox=this.taskdata[i].chkbox;
    
    if(this.taskdata[i].chkbox==true)
    {
     this.taskdata[i].chkbox=1
    }
    else
    this.taskdata[i].chkbox=0;
    
    this.ser.checkbox(this.taskdata[i]).subscribe(d=>{this.taskdata=d,this.retrieve()});
    //this.ser.status().subscribe();
  }


 
   
   temp=(localStorage.getItem("crtuser"));

  // savetask()
  // {
     
  //         this.data1.email=this.temp;
  //   // alert("hi");
  //   // 
    
  //   this.ser.tasksave(this.data1).subscribe(d=>{this.taskdata=d,this.retrieve()});
  //   alert(this.data1);
    

  // }
  savetask()
  {
     
          this.data1.email=this.temp;
          this.data1.taskdate=this.taskdate;
          // this.data1.taskdate=formatDate(this.taskdate, 'yyyy/MM/dd', 'en');
    // alert("hi");
    // 
    
    this.ser.tasksave(this.data1).subscribe(d=>{this.taskdata=d,this.retrieve()});
    alert(this.data1);
    this.data1="";
    

  }

  tvar:number;
  btn=false;
  edit(j)
  {
    this.btn=true;
    this.add=false;
    this.tvar=j;
    for(let i=0;i<this.taskdata.length;i++)
    {
       if(i==j)
       {
       this.data1=this.taskdata[i];
       }
    }

  }

  modify()
  {
    for(let i=0;i<this.taskdata.length;i++)
    {
      if(i==this.tvar)
      {
        this.taskdata[i]=this.data1;
        this.ser.updatetask(this.taskdata[i]).subscribe(d=>{this.taskdata=d,this.retrieve()})
      }
    }
    this.data1=" ";
    this.add=true;
  }

  tempobj:any={};
  delete(i)
  {
    this.tempobj.tid=this.taskdata[i].tid;
    this.ser.deletetask(this.tempobj).subscribe(d=>{this.taskdata=d,this.retrieve()});

  }

  signout()
  {
    localStorage.setItem("islogin","false");
    localStorage.removeItem("crtuser");
    alert("successfully logged out");
    
    this.rou.navigate(['/login']);
  }


}
