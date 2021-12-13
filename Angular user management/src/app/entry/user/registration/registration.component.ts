import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styles: []
})
export class RegistrationComponent implements OnInit {

  constructor(public service: UserService, private toastr: ToastrService) { }

  ngOnInit() {
    this.service.formModel.reset();
  }

  onSubmit() {
    this.service.register().subscribe(
      (res: any) => {
        if (res.status==200) {
          this.service.formModel.reset();
          this.toastr.success('New user created!', 'Registration successful.');
        } else  if (res.data=="Mail already exists") {
          
                this.toastr.error('Email is already taken','Registration failed.');
               
        } else {
            this.toastr.error(res.message,'Registration failed.');
            }
          });
        
      
    (      err: any) => {
        console.log(err);
      }
    
  }

}
