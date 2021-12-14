import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Facture } from '../model/facture.model';
import { FactureService } from '../services/facture.service';
import {jsPDF} from 'jspdf';

import "pdfmake/build/pdfmake"
import html2canvas from 'html2canvas';



@Component({
  selector: 'app-consulter-facture',
  templateUrl: './consulter-facture.component.html',
  styleUrls: ['./consulter-facture.component.css']
})
export class ConsulterFactureComponent implements OnInit {
  currentFacture = new Facture();
  factures=new Facture();
  
  
  
 
  constructor(private activatedRoute: ActivatedRoute,
    private factureService: FactureService,
    private router: Router,
    
    
  ) { }
  
  consulterFacture() {
    this.factureService.consulterFacture(this.activatedRoute.snapshot.params.id).subscribe((res:any)=>{
      console.log(res);
  
      this.factures = res;
      console.log(this.factures);
      
      console.log("id:"+this.activatedRoute.snapshot.params.id);
  
      
    },
    (error)=>{
      console.log(error)
    
    });}
    updateFacture(f:Facture) {
      this.factureService.updateFacture(f).subscribe(prod => {
      this.router.navigate(['factures']);
      },(error) => {console.log(error); }
      );
      }
      
     
      public downloadAsPDF()
  {

  var element = document.getElementById('contentToConvert') as HTMLElement;
  html2canvas(element).then(canvas => {
    var imgW = 200;
    var imgH = canvas.height * imgW /canvas.width	;
    const contentDataURL = canvas.toDataURL('image/png')
    let pdf = new jsPDF('p','mm','a4');
    var position = 0;
    pdf.html("")
    pdf.addImage(contentDataURL,'PNG',0,position,imgW,imgH)
    pdf.save("asddsfdfk.pdf");  
  });
}

  ngOnInit(): void {
    this.consulterFacture();
  }
  
  }

