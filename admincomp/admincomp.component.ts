import { Component, OnInit } from '@angular/core';
import { TaskServiceService } from '../task-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admincomp',
  templateUrl: './admincomp.component.html',
  styleUrls: ['./admincomp.component.css']
})
export class AdmincompComponent implements OnInit {

  regdata:any=[];

  constructor(private ser:TaskServiceService,private rou:Router) { }

  ngOnInit() {
    this.ser.regview().subscribe(d=>this.regdata=d);
  }

  activate(i)
  {
    this.ser.activateUser(this.regdata[i]).subscribe(d=>this.regdata=d);
  }
  deactivate(i)
  {
    this.ser.deactivateUser(this.regdata[i]).subscribe(d=>this.regdata=d);
  }
  logout()
  {
    localStorage.setItem("islogin","false");
    this.rou.navigate(['/login']);

  }

  report()
  {
    this.rou.navigate(['/report']);

  }

}
