import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FacturesComponent } from './factures/factures.component';
import { AddFactureComponent } from './add-facture/add-facture.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateFactureComponent } from './update-facture/update-facture.component';
import { HttpClientModule } from '@angular/common/http';
import { ConsulterFactureComponent } from './consulter-facture/consulter-facture.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProductComponent } from './product/product.component';
import { MainProductComponent } from './main-product/main-product.component';
import { FormProductComponent } from './form-product/form-product.component';
import{BrowserAnimationsModule}from'@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';


@NgModule({
  declarations: [
    AppComponent,
    FacturesComponent,
    AddFactureComponent,
    UpdateFactureComponent,
    ConsulterFactureComponent,
    NavbarComponent,
    ProductComponent,
    MainProductComponent,
    FormProductComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      timeOut: 5000,
     // positionClass: 'toast-bottom-right',
      preventDuplicates: true,
      progressBar:true,
      progressAnimation:'increasing',
      
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
