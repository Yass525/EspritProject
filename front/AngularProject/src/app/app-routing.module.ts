import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FacturesComponent } from './factures/factures.component';
import { AddFactureComponent } from './add-facture/add-facture.component';
import { UpdateFactureComponent } from './update-facture/update-facture.component';
import { ConsulterFactureComponent } from './consulter-facture/consulter-facture.component';
import { ProductComponent } from './product/product.component';
import { MainProductComponent } from './main-product/main-product.component';



const routes: Routes = [
  {path: "factures", component : FacturesComponent},
  {path: "add-facture", component : AddFactureComponent},
  {path: "updateFacture/:id", component: UpdateFactureComponent},
  {path: "consulter-facture/:id", component: ConsulterFactureComponent},
  {path:"product",component:ProductComponent},
  {path:"product-main",component:MainProductComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
