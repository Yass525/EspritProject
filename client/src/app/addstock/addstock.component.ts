import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
//import { DialogContentExampleDialog } from './dialog-delete.component';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';




@Component({
  selector: 'app-addstock',
  templateUrl: './addstock.component.html',
  styleUrls: ['./addstock.component.css']
})
export class AddstockComponent implements OnInit {

  model!: StockData;

  constructor(private http : HttpClient,public dialog: MatDialog,private router: Router) {
  this.model = new StockData();
   }

  ngOnInit(): void {



 

  /*openDeleteDialog(): void {
    let dialogRef = this.dialog.open(DialogContentExampleDialog , {
      width: '250px'
    });
  
    dialogRef.afterClosed().subscribe(result => {
      
    });
  }*/

}




insert():void{
  console.log(this.model)
  this.http.post<any>('http://localhost:8082/stock/add', this.model).subscribe(data => {
    this.router.navigate(['/']);
    
    })
  }



}



export class StockData {
  IdStock!: number;
  QteStock!: number;
  QteMin!: number;
  LibelleStock!: string;
  constructor(){
    
  }
  }