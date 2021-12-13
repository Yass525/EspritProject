import { ToastrService } from 'ngx-toastr';
import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import { MatSnackBar } from '@angular/material/snack-bar';
import { CookieService } from 'ngx-cookie-service';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/app/shared/user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: []
})
export class LoginComponent implements OnInit {
  formModel = {
    username: '',
    password: ''
  }
  constructor(private service: UserService, private router: Router,
    private toastr: ToastrService, public snackbar: MatSnackBar, private cookieService: CookieService) { }

  ngOnInit() {
    //if (localStorage.getItem('token') != null)
      //this.router.navigateByUrl('/home');
      if (this.cookieService.get('token'))
       this.router.navigateByUrl('/home');
  }

  
  onSubmit(form: NgForm) {
    this.service.login(form.value).subscribe(
      (res: any) => {
       // localStorage.setItem('token', res.data);
        this.cookieService.set('token', res.data, 1, '/','localhost', true, "Lax");
       //this.cookieService.set('token', res.data);
        this.router.navigateByUrl('/home');
      },
      err => {
        if (err.status != 200) {
             this.toastr.error('Incorrect username or password.', 'Authentication failed.');
          this.router.navigateByUrl('/entry/user/login');
          
        }
       //this.snackbar.open('Incorrect username or password.', 'Close', {
    //          duration: 3000,
    //          horizontalPosition: 'right',
    //          verticalPosition: 'top',
    //          panelClass:['redNoMatch']
    //       });
        else
          console.log(err);
      }
    );
  }
}
