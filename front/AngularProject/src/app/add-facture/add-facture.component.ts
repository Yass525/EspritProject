import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Facture } from '../model/facture.model';
import { FactureService } from '../services/facture.service';

@Component({
  selector: 'app-add-facture',
  templateUrl: './add-facture.component.html',
  styleUrls: ['./add-facture.component.css']
})
export class AddFactureComponent implements OnInit {
  newFacture = new Facture();

  constructor(private factureService: FactureService, private router :Router,private toastr: ToastrService    ) { }
  
  addFacture(){
    this.factureService.ajouterFacture(this.newFacture)
    .subscribe(prod => {
    console.log(prod);
    this.toastr.success('new facture added','new facture');
    });
    this.router.navigate(['factures']);
    }
  
  ngOnInit(): void {
  }

}
