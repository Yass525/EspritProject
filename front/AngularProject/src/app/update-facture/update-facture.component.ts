import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Facture } from '../model/facture.model';
import { FactureService } from '../services/facture.service';

@Component({
  selector: 'app-update-facture',
  templateUrl: './update-facture.component.html',
  styles: [
  ]
})
export class UpdateFactureComponent implements OnInit {
  currentFacture = new Facture();
  @Output() notif= new EventEmitter();
  div1:boolean=true

  constructor(private activatedRoute: ActivatedRoute,
    private router: Router,
    private factureService: FactureService) { }

  
    updateFacture() {
      this.factureService.updateFacture(this.currentFacture).subscribe(prod => {

      this.notif.emit(this.router.navigate(['factures']));
      },(error) => { alert("Problème lors de la modification !"); }
      );
      }
      div1Function(){
        this.div1=!this.div1
    }
      
    


  ngOnInit(): void {
    //console.log(this.activatedRoute.snapshot.params.id);

    this.factureService.consulterFacture(this.activatedRoute.snapshot.params.id).
      subscribe(prod => { this.currentFacture = prod; });



  }

}
