import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from '../shared/user.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userDetails;

  constructor(private router: Router, public service: UserService, private toastr: ToastrService) { }

  ngOnInit() {
    this.service.getUserProfile().subscribe(
      res => {
        this.userDetails = res;
        console.log(res);
      },
      err => {
        console.log(err);
      },
    );
   
  }

  redirectTo(uri:string){
   this.router.navigateByUrl('/', {skipLocationChange: true} ).then(()=>
   this.router.navigate([uri]));
}

  public onOpenModal(type: String, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'facture') {
      
    }
    if (mode === 'edit') {
      
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
   
    container.appendChild(button);
    button.click();
  }

  onSubmit() {
    this.service.update().subscribe(
      (res: any) => {
        if (res.status==200) {
          this.service.formModel2.reset();
          this.toastr.success('User updated', 'updated successful.');
        
        } else  if (res.data=="Mail already exists") {
          
         this.toastr.error('Email is already taken','Choose another e-mail');
               
        } else {

          this.toastr.error(res.message, 'Update failed.');
          
            }
          });
        
      
      err => {
        console.log(err);
      }
    
  }

  refresh() {
    this.redirectTo("/home");
  }
}
