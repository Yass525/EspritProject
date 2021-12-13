import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AuthGuard } from '../auth/auth.guard';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { UsersListPaginatedComponent } from './users-list-paginated/users-list-paginated.component';


const routes: Routes = [
 
  {
    path: 'adminpanel',
    component: AdminPanelComponent,
    canActivate: [AuthGuard],
    data: { permittedRoles: ['ROLE_ADMIN'] }
  },
  {
    path: 'userslistpaginated',
    component: UsersListPaginatedComponent,
    canActivate: [AuthGuard],
    data: { permittedRoles: ['ROLE_ADMIN'] }
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
