import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-admin-profile-for-user',
  templateUrl: './admin-profile-for-user.component.html',
  styleUrls: ['./admin-profile-for-user.component.css']
})
export class AdminProfileForUserComponent implements OnInit {
  userDetails;
  id;

  constructor(private router: Router, public service: UserService,private _Activatedroute:ActivatedRoute) { }

  ngOnInit(): void {
     this.id=this._Activatedroute.snapshot.paramMap.get("id");

     this.service.getUserProfileForAdmin(this.id).subscribe(
      res => {
        this.userDetails = res;
        console.log(res);
      },
      err => {
        console.log(err);
      },
     );
    
  }

}
