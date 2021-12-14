import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
//import { DialogContentExampleDialog } from './dialog-delete.component';
import { MatDialog } from '@angular/material/dialog';



@Component({
  selector: 'app-logtable',
  templateUrl: './logtable.component.html',
  styleUrls: ['./logtable.component.css']
})
export class LogtableComponent implements OnInit {
  EmptyEntries: number ;
  LowEntries: number ;
  AvgEntries: number ;
  TotalEntries: number ;
  page: number;
  dataSource: LogData[];
  fake: number[];
  displayedColumns = ['action','date','id_requester','id_stock','type','value'];
  constructor(private http : HttpClient,public dialog: MatDialog) {
    this.EmptyEntries = 0;
    this.AvgEntries = 0;
    this.LowEntries = 0;
    this.TotalEntries = 0;
    this.page = 1;
    this.dataSource = [];
    this.fake =[];
   }

  ngOnInit(): void {


    

    this.http.get<number>('http://localhost:8082/stocklogs/count')
    .subscribe(Response => {
 
      if(Response){ 
        console.log("SUCCESS")
        
        this.EmptyEntries = Response;
      
      }
      

    });


    this.http.get<LogData[]>('http://localhost:8082/stocklogs/all')
    .subscribe(Response => {
 
      if(Response){ 
        console.log("SUCCESS")
        this.dataSource = Response;
      
      }

      console.log(Response)

    });

  }

  filter(s:string):void{
    this.http.get<LogData[]>('http://localhost:8082/stocklogs/bytype/'+s)
    .subscribe(Response => {
 
      if(Response){ 
        console.log("SUCCESS")
        this.dataSource = Response;
      
      }

      console.log(Response)

    });

  }
  reset():void{
    this.http.get<LogData[]>('http://localhost:8082/stocklogs/all')
    .subscribe(Response => {
 
      if(Response){ 
        console.log("SUCCESS")
        this.dataSource = Response;
      
      }

      console.log(Response)

    });
  }


  /*openDeleteDialog(): void {
    let dialogRef = this.dialog.open(DialogContentExampleDialog , {
      width: '250px'
    });
  
    dialogRef.afterClosed().subscribe(result => {
      
    });
  }*/

}

export interface LogData {
id: number,
action: string,
date: Date,
id_requester: number,
id_stock: number,
type: string,
value: number
}