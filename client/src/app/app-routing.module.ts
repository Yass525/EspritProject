import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddstockComponent } from './addstock/addstock.component';
import { EditstockComponent } from './editstock/editstock.component';
import { LogtableComponent } from './logtable/logtable.component';
import { StocktableOosComponent } from './stocktable-oos/stocktableoos.component';
import { StocktableRoComponent } from './stocktable-ro/stocktablero.component';
import { StocktableComponent } from './stocktable/stocktable.component';
import { PreloadAllModules } from '@angular/router';

const routes: Routes = [{ path: '', component: StocktableComponent },
{ path: 'outofstock', component: StocktableOosComponent },
{ path: 'lowstock', component: StocktableRoComponent },
{ path: 'logs', component: LogtableComponent },
{ path: 'addstock', component: AddstockComponent },
{ path: 'editstock/:id', component: EditstockComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
