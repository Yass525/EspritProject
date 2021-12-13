import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {PageEvent} from '@angular/material/paginator';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { map, tap } from 'rxjs/operators';
import { UserData } from 'src/app/shared/user.service';
import { UserService } from 'src/app/shared/user.service';

@Component({
  selector: 'app-users-list-paginated',
  templateUrl: './users-list-paginated.component.html',
  styleUrls: ['./users-list-paginated.component.css']
})
export class UsersListPaginatedComponent implements OnInit {
   
  filterValue: string = null;
  dataSource: UserData = null;
  pageEvent: PageEvent;

  displayedColumns: string[] = ['id', 'name', 'email', 'role'];
 

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private userService: UserService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    
    this.initDataSource();
    // this.dataSource.paginator = this.paginator;
  }

   initDataSource() {
     this.userService.findAll(1, 5).pipe(
      tap(users => console.log(users)),
      map((userData: UserData) => this.dataSource = userData)
    ).subscribe();
   }
  
  onPaginateChange(event: PageEvent) {
    let page = event.pageIndex;
    let size = event.pageSize;

    page = page + 1;
    
    if(this.filterValue == null) {
      page = page +1;
      this.userService.findAll(page, size).pipe(
        map((userData: UserData) => this.dataSource = userData)
      ).subscribe();
    } else {
      this.userService.paginateByName(page, size, this.filterValue).pipe(
        map((userData: UserData) => this.dataSource = userData)
      ).subscribe()
    }
    
  } 

  
  findByName(username: string) {
    console.log(username);
    this.userService.paginateByName(0, 10, username).pipe(
      map((userData: UserData) => this.dataSource = userData)
    ).subscribe()
  }


  navigateToProfile(id) {
  this.router.navigate(['./' + id], {relativeTo: this.activatedRoute});
  }
 
}
