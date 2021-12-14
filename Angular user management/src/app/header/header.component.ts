import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styles: []
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router, private cookieService: CookieService) { }

  ngOnInit() {
    if (this.cookieService.check("token")) {
      var v = document.getElementById('loginBtn');
      v.style.visibility = 'visible';
    }

    var payLoad = JSON.parse(window.atob(this.cookieService.get('token').split('.')[1]));
    var userRole = payLoad.role;
    console.log( userRole)
    if (userRole == "ROLE_ADMIN") {
      var v = document.getElementById('admin');
      var v2 = document.getElementById('admin2');
      v.style.visibility = 'visible';
      v2.style.visibility = 'visible';
      console.log("header for admin"+ userRole)
    }

  }
 onLogout() {
   //localStorage.removeItem('token');
   this.cookieService.delete("token", '/');
   this.router.navigate(['/entry/user/login']);
    var v = document.getElementById('admin');
      var v2 = document.getElementById('admin2');
      v.style.visibility = 'hidden';
   v2.style.visibility = 'hidden';
    var f = document.getElementById('loginBtn');
      f.style.visibility = 'hidden';
 }
 
}
function addRecord() {
  var payLoad = JSON.parse(window.atob(this.cookieService.get('token').split('.')[1]));
  var userRole = payLoad.role;
  if (userRole == "ROLE_ADMIN") {
    var v = document.getElementById('admin');
    v.style.visibility = 'visible';
    console.log("header for admin")
  }
    
}
  
