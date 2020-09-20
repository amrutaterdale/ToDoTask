import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import {Chart} from 'chart.js';
@Component({
  selector: 'app-count',
  templateUrl: './count.component.html',
  styleUrls: ['./count.component.css']
})
export class CountComponent implements OnInit {
  barchart=[];

  constructor(private rou:Router) { }

  ngOnInit() {
    
      
    
  }
  @Input() registercount:number;
  @Input() activecount:number;
  @Input() taskcount:number;


}
