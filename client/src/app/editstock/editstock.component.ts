import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
//import { DialogContentExampleDialog } from './dialog-delete.component';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';




@Component({
  selector: 'app-editstock',
  templateUrl: './editstock.component.html',
  styleUrls: ['./editstock.component.css']
})
export class EditstockComponent implements OnInit {

  model!: StockData;
  id: string;
  constructor(private http : HttpClient,public dialog: MatDialog,private router: Router,private _Activatedroute:ActivatedRoute) {
  this.model = new StockData();
  this.id ='';
   }

  ngOnInit(): void {
    this.id=this._Activatedroute.snapshot.paramMap.get("id") || '';

    this.http.get<StockData>('http://localhost:8082/stock/get/'+this.id).subscribe(data => {
     this.model.IdStock = data.IdStock;
     this.model.QteStock = data.QteStock;
     this.model.QteMin = data.QteMin;
     this.model.LibelleStock = data.LibelleStock;

     console.log(this.model);
      })

 

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
  this.http.post<any>('http://localhost:8082/stock/update/'+this.id, this.model).subscribe(data => {
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