import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { RouterModule, ROUTES } from '@angular/router';
import { UsersListPaginatedComponent } from './users-list-paginated/users-list-paginated.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';

console.warn("admin module loaded");
@NgModule({
  declarations: [
    AdminComponent,
    UsersListPaginatedComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatPaginatorModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatTableModule,

        MatInputModule
    
  ],
  exports: [
    RouterModule
  ]
})
export class AdminModule { }
