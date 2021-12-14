import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StocktableComponent } from './stocktable/stocktable.component';
import { StocktableOosComponent } from './stocktable-oos/stocktableoos.component'
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';


import { HttpClientModule } from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { StocktableRoComponent } from './stocktable-ro/stocktablero.component';
import { LogtableComponent } from './logtable/logtable.component';
import { AddstockComponent } from './addstock/addstock.component';
import { FormsModule } from '@angular/forms';
import { EditstockComponent } from './editstock/editstock.component';


@NgModule({
  declarations: [
    AppComponent,
    StocktableComponent,
    StocktableOosComponent,
    StocktableRoComponent,
    LogtableComponent,
    AddstockComponent,
    EditstockComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
    MatDialogModule,
    FormsModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
