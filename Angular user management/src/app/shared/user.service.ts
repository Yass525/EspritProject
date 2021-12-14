import { Injectable } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { CookieService } from 'ngx-cookie-service';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

export interface UserData{
  
  "content": [
    {
      "idClient": number,
      "nom": string,
      "prenom": string,
      "dateNaissance": Date,
      "eMail": string,
      "categoryClient": string,
      "profession": string,
      "role": string,
      "enabled": boolean,
      
    }
  ],
  "pageable": {
    "pageNumber": number,  
    "pageSize": number,
  },
  "totalPages": number,
   "totalElements": number,
}

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private fb: FormBuilder, private http: HttpClient, private cookieService: CookieService) { }
  readonly BaseURI = 'http://localhost:8082';

  formModel = this.fb.group({
    UserName: ['', Validators.required],
    Email: ['', Validators.email],
    FullName: ['', Validators.required],
    Passwords: this.fb.group({
      Password: ['', [Validators.required, Validators.minLength(4)]],
      ConfirmPassword: ['', Validators.required]
    }, { validator: this.comparePasswords }),
    Birthday : ['', Validators.required],
    Categorie: ['', Validators.required],
    Profession : ['', Validators.required]
  });

  formModel2 = this.fb.group({
    UserName: ['', Validators.minLength(4)],
    Email: ['', Validators.email],
    FullName: ['',Validators.minLength(4)], 
    Birthday : ['', ]
 
  });

  comparePasswords(fb: FormGroup) {
    let confirmPswrdCtrl = fb.get('ConfirmPassword');
    //passwordMismatch
    //confirmPswrdCtrl.errors={passwordMismatch:true}
    if (confirmPswrdCtrl.errors == null || 'passwordMismatch' in confirmPswrdCtrl.errors) {
      if (fb.get('Password').value != confirmPswrdCtrl.value)
        confirmPswrdCtrl.setErrors({ passwordMismatch: true });
      else
        confirmPswrdCtrl.setErrors(null);
    }
  }

  register() {
    var body = {
      nom: this.formModel.value.UserName,
      eMail: this.formModel.value.Email,
      prenom: this.formModel.value.FullName,
      password: this.formModel.value.Passwords.Password,
      dateNaissance: this.formModel.value.Birthday,
      categoryClient: this.formModel.value.Categorie,
      profession: this.formModel.value.Profession
    };
    return this.http.post(this.BaseURI + '/register', body);
  }

  update() {
    var body = {
      nom: this.formModel2.value.UserName,
      eMail: this.formModel2.value.Email,
      prenom: this.formModel2.value.FullName,   
      dateNaissance: this.formModel2.value.Birthday    
    };
    var header = new HttpHeaders({ 'Authorization': 'Bearer ' + this.cookieService.get('token') })
    console.log(this.cookieService.get('token'));
    console.log(header.get('Authorization'));
     console.log(body);
    return this.http.post(this.BaseURI + '/update', body, {headers : header});
  }
  
  login(formData) {
    return this.http.post(this.BaseURI + '/authenticate', formData);
  }

  getUserProfile() {
    
   var header = new HttpHeaders({ 'Authorization': 'Bearer ' +  this.cookieService.get('token') })
    //let header = new HttpHeaders();
    //header.set( 'Content-Type','application/json');
    //header.set('Authorization', 'Bearer ' + localStorage.getItem('token'));
    console.log(this.cookieService.get('token'));
    console.log(header.get('Authorization'));
    return this.http.get(this.BaseURI + '/profile', {headers : header});
  }

  getUserProfileForAdmin(id: number) {
    let params = new HttpParams();
   var header = new HttpHeaders({ 'Authorization': 'Bearer ' +  this.cookieService.get('token') })
   params = params.append('id', (id));
    return this.http.get(this.BaseURI + '/userProfile/',{params});
  }


   findAll(page: number, size: number): Observable<UserData> {
    let params = new HttpParams();

    params = params.append('pageNumber', String(page));
    params = params.append('pageSize', String(size));

    return this.http.get(this.BaseURI +'/clientPaged', {params}).pipe(
      map((userData: UserData) => userData),
      catchError(err => throwError(err))
    )
   }
  
   paginateByName(page: number, size: number, username: string): Observable<UserData> {
    let params = new HttpParams();

    params = params.append('pageNumber', String(page));
    params = params.append('pageSize', String(size));
    params = params.append('nom', username);

    return this.http.get(this.BaseURI +'/clientPaged', {params}).pipe(
      map((userData: UserData) => userData),
      catchError(err => throwError(err))
    )
  }

  roleMatch(allowedRoles): boolean {
    var isMatch = false;
    var payLoad = JSON.parse(window.atob(this.cookieService.get('token').split('.')[1]));
    var userRole = payLoad.role;
    console.log(payLoad.role);
    allowedRoles.forEach(element => {
      if (userRole == element) {
        isMatch = true;
        return false;
      }
    });
    return isMatch;
  }
}
