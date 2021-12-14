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
import {MatSortModule} from '@angular/material/sort';
import { A11yModule, LiveAnnouncer } from '@angular/cdk/a11y';
import { AdminProfileForUserComponent } from './admin-profile-for-user/admin-profile-for-user.component';

console.warn("admin module loaded");
@NgModule({
  declarations: [
    AdminComponent,
    UsersListPaginatedComponent,
    AdminProfileForUserComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatPaginatorModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatTableModule,
    MatSortModule,
    MatInputModule,
    A11yModule

    
  ],
  exports: [
    RouterModule
  ]
})
export class AdminModule { }
