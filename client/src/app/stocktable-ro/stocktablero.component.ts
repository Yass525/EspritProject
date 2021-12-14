import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
//import { DialogContentExampleDialog } from './dialog-delete.component';
import { MatDialog } from '@angular/material/dialog';



@Component({
  selector: 'app-stocktable-ro',
  templateUrl: './stocktablero.component.html',
  styleUrls: ['./stocktablero.component.css']
})
export class StocktableRoComponent implements OnInit {
  EmptyEntries: number ;
  LowEntries: number ;
  AvgEntries: number ;
  TotalEntries: number ;
  Empty:number;
  page: number;
  dataSource: StockData[];
  fake: number[];
  displayedColumns = ['IdStock', 'LibelleStock', 'QteStock', 'QteMin','Status'];
  constructor(private http : HttpClient,public dialog: MatDialog) {
    this.EmptyEntries = 0;
    this.AvgEntries = 0;
    this.LowEntries = 0;
    this.TotalEntries = 0;
    this.page = 1;
    this.dataSource = [];
    this.fake =[];
    this.Empty = 0;
   }

  ngOnInit(): void {


    this.http.get<number[]>('http://localhost:8082/stock/info')
    .subscribe(Response => {
 
      if(Response){ 
        console.log("SUCCESS")
        
        this.EmptyEntries = Math.round((Response[0]/Response[3])*100 * 10) /10;
        this.AvgEntries = Math.round((Response[1]/Response[3])*100 * 10) /10;
        this.LowEntries = Math.round((Response[2]/Response[3])*100 * 10) /10;
        this.TotalEntries = Response[3];
        this.Empty = Response[1];

        if(this.TotalEntries%20 == 0)
        this.fake = this.fakeArray(this.TotalEntries/20 | 0);
        else
        this.fake = this.fakeArray((this.TotalEntries/20)+1 | 0);
        
     
        
      }
      

    });


    this.http.get<StockData[]>('http://localhost:8082/stock/low')
    .subscribe(Response => {
 
      if(Response){ 
        console.log("SUCCESS")
        this.dataSource = Response;
      
      }

      console.log(Response)

    });

  }

  setPage(p:number):void {
    this.page = p;
    console.log("SET PAGE "+p)
    this.http.get<StockData[]>('http://localhost:8082/stock/getpage/'+p)
    .subscribe(Response => {
 
      if(Response){ 
        console.log("SUCCESS")
        this.dataSource = Response;
      
      }


    });
  }

  fakeArray(length: number): Array<number> {
    if (length >= 0) {
      return new Array<number>(length);
    }
    return new Array<number>(0);
  }

  /*openDeleteDialog(): void {
    let dialogRef = this.dialog.open(DialogContentExampleDialog , {
      width: '250px'
    });
  
    dialogRef.afterClosed().subscribe(result => {
      
    });
  }*/

}

export interface StockData {
IdStock: number,
QteStock: number,
QteMin: number,
LibelleStock: string
}