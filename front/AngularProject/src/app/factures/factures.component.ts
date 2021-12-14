import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Facture } from '../model/facture.model';
import { FactureService } from '../services/facture.service';

@Component({
  selector: 'app-factures',
  templateUrl: './factures.component.html',
  styleUrls: ['./factures.component.css']
})
export class FacturesComponent implements OnInit {
  factures?: Facture[]; //un tableau de chînes de caractères

  constructor(private factureService: FactureService, private router: Router,private toastr: ToastrService) {
    // this.factures = factureService.listeFacture();
  }

  deleteFacture(p: Facture) {
    let conf = confirm("Etes-vous sûr ?");
    if (conf)
      this.factureService.deleteFacture(p.idFacture).subscribe(() => {
       this.toastr.error('facture spprimee','facture',{
         timeOut:1000000
       });
      });
    this.router.navigate(['factures']).then(() => {
      window.location.reload();
    });
  }
  deleteFactureDuTableau(prod: Facture) {
    this.factures?.forEach((cur, index) => {
      if (prod.idFacture === cur.idFacture) {
        this.factures?.splice(index, 1);
      }
    });
  }

  ngOnInit(): void {
    this.factureService.listeFacture().subscribe(prods => {
      console.log(prods);
      this.factures = prods;
    });

  }

}
