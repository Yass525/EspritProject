import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EntryRoutingModule } from './entry-routing.module';
import { EntryComponent } from './entry.component';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule, ɵInternalFormsSharedModule } from '@angular/forms';
import { RegistrationComponent } from './user/registration/registration.component';
import { LoginComponent } from './user/login/login.component';
import { AppComponent } from '../app.component';
import { BrowserModule } from '@angular/platform-browser';
import { UserComponent } from './user/user.component';


@NgModule({
  declarations: [
    EntryComponent,
    RegistrationComponent,
    LoginComponent,
    UserComponent
 
  ],
  imports: [
    CommonModule,
    RouterModule,
    EntryRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    RouterModule
  ]
})
export class EntryModule { }
