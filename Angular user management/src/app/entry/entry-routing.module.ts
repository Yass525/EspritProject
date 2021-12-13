import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EntryComponent } from './entry.component';
import { LoginComponent } from './user/login/login.component';
import { RegistrationComponent } from './user/registration/registration.component';
import { UserComponent } from './user/user.component';


const routes: Routes = [
 
  {
    path: 'user',
    component: UserComponent,
      children: [
        {
          path: 'registration',
          component: RegistrationComponent
        },
        {
          path: 'login',
          component: LoginComponent
        }
      ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EntryRoutingModule { }
