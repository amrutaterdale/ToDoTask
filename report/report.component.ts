import { Component, OnInit } from '@angular/core';
import { TaskServiceService } from '../task-service.service';
import {Chart} from 'chart.js';
import { Router } from '@angular/router';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
// import * as CanvasJS from './canvasjs.min';
// import * as CanvasJS from '.\assets\canvasjs.min.js';


@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  regdata:any=[];
  today:any=new Date();
  taskdata:any=[];
  barchart:any=[];
  

  constructor(private ser:TaskServiceService,private rou:Router) {
    // alert("hi");
  }
  dt;any;
  regcount:number=0;
  totaltask:number=0;
  activeuser:number=0;
  logview:any=[];
  ngOnInit() {
    // this.ser.regview().subscribe(d=>this.regdata=d);
    this.ser.regview().subscribe(d=>{this.regdata=d
    for(let i=0;i<this.regdata.length;i++)
    {
      this.dt=new Date(this.regdata[i].regDate);
    if(Math.floor((Date.UTC(this.today.getFullYear(),this.today.getMonth(),this.today.getDate())
        -Date.UTC(this.dt.getFullYear(),this.dt.getMonth(),this.dt.getDate()))/(1000*3600*24))<=7)
        {
          this.regcount=this.regcount+1;
          // alert("hi");
          // alert(this.regcount)
        }
      }
    });

    this.ser.taskview().subscribe(d=>{this.taskdata=d
      for(let i=0;i<this.taskdata.length;i++)
      {
        this.dt=new Date(this.taskdata[i].taskdate);
      if(Math.floor((Date.UTC(this.today.getFullYear(),this.today.getMonth(),this.today.getDate())
          -Date.UTC(this.dt.getFullYear(),this.dt.getMonth(),this.dt.getDate()))/(1000*3600*24))<=7)
          {
            this.totaltask=this.totaltask+1;
            // alert("hi");
            // alert(this.regcount)
          }
        }
      });

//       // this.ser.actview().subscribe(d=>{this.logview=d
//       //   for(let i=0;i<this.logview.length;i++)
//       //   {
//       //     this.dt=new Date(this.logview[i].logindate);
//       //   if(Math.floor((Date.UTC(this.today.getFullYear(),this.today.getMonth(),this.today.getDate())
//       //       -Date.UTC(this.dt.getFullYear(),this.dt.getMonth(),this.dt.getDate()))/(1000*3600*24))<=7)
//       //       {
//       //         this.activeuser=this.activeuser+1;
//       //         // alert("hi");
//       //         // alert(this.regcount)
//       //       }
//       //     }
//       //   });
        this.ser.actview().subscribe(d=>{this.logview=d
  for(let i=0;i<this.logview.length;i++)
  {
    for(let j=i+1;j<this.logview.length;j++)
    {
      if(this.logview[i].email==this.logview[j].email)
      {
        this.logview.splice(i,1);
      }
    }
      this.dt=new Date(this.logview[i].logindate);
  if(Math.floor((Date.UTC(this.today.getFullYear(),this.today.getMonth(),this.today.getDate())
      -Date.UTC(this.dt.getFullYear(),this.dt.getMonth(),this.dt.getDate()))/(1000*3600*24))<=7)
      {
        this.activeuser=this.activeuser+1;
        // alert("hi");
        // alert(this.regcount)
      }
    
    }
  
 });
// this.ser.actview().subscribe(d=>{this.logview=d
//   for(let i=0;i<this.logview.length;i++)
//   {
//     this.dt=new Date(this.logview[i].logindate);
//   if(Math.floor((Date.UTC(this.today.getFullYear(),this.today.getMonth(),this.today.getDate())
//       -Date.UTC(this.dt.getFullYear(),this.dt.getMonth(),this.dt.getDate()))/(1000*3600*24))<=7)
//       {
//         this.activeuser=this.activeuser+1;
//         // alert("hi");
//         // alert(this.regcount)
//       }
//     }
//   });

// this.barchart=new Chart('barChart',{type:'bar',data:{
//   labels:["registereduser","Activeusers","totaltask"],
//   datasets:[{
//     label:'users',
//     data:[3,5,9],
//     backgroundColor:[
//       'blue',
//       'blue',
//       'pink'
//     ],
//     borderColor:[
//       'blue',
//       'blue',
//       'pink'
//     ],
//     borderWidth:1
//   }]
// },
// options:{
//   title:{
//     text:"Bar chart",
//     display:true
//   },
//   scales:{
//     yAxes:[{
//       ticks:{
//         beginAtZero:true
//       }
//     }]
//   }
// }
// });

    }

    type()
    {
      this.barchart=new Chart('barChart',{type:'bar',data:{
        labels:["RegisteredUser","ActiveUsers","TotalTask"],
        datasets:[{
          label:'Number of users in last 7 days',
          data:[this.regcount,this.activeuser,this.totaltask],
          backgroundColor:[
            'blue',
            'green',
            'pink'
          ],
          borderColor:[
            'blue',
            'green',
            'pink'
          ],
          borderWidth:1
        }]
      },
      options:{
        title:{
          text:"Bar chart",
          display:true
          
        },
        scales:{
          yAxes:[{
            ticks:{
              beginAtZero:true
            }
          }]
        }
      }
      });
    }

    back()
    {
      this.rou.navigate(['/admin']);
    }
  
    
  
  }





        



