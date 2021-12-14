import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {PageEvent} from '@angular/material/paginator';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { map, tap } from 'rxjs/operators';
import { UserData } from 'src/app/shared/user.service';
import { UserService } from 'src/app/shared/user.service';
import { MatSort, Sort } from '@angular/material/sort';
import {LiveAnnouncer} from '@angular/cdk/a11y';

@Component({
  selector: 'app-users-list-paginated',
  templateUrl: './users-list-paginated.component.html',
  styleUrls: ['./users-list-paginated.component.css']
})
export class UsersListPaginatedComponent implements OnInit,AfterViewInit{
   
  filterValue: string = null;
  dataSource: UserData = null;
  pageEvent: PageEvent;
 
  displayedColumns: string[] = ['id', 'name', 'email', 'role'];
 

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  UserData: any;
  
  constructor(private userService: UserService, private router: Router, private activatedRoute: ActivatedRoute,
    private _liveAnnouncer: LiveAnnouncer) { 
 
  }
  
  ngAfterViewInit(): void {
    
  }



  ngOnInit(): void {
    
    this.initDataSource();
    
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
  this.router.navigate(['/specProfile' , 10], {relativeTo: this.activatedRoute});
  }

  announceSortChange(sort: Sort) {
    // const data = this.dataSource;
    // if (!sort.active || sort.direction === '') {
    //   this.dataSource = data;
    //   return;
    // }

    // this.dataSource = data.content.sort((a, b) => {
    //   const isAsc = sort.direction === 'asc';
    //   switch (sort.active) {
    //     case 'id':
    //       return compare(a.idClient, b.id, isAsc);
    //     case 'name':
    //       return compare(a.name, b.name, isAsc);
    //     case 'email':
    //       return compare(a.email, b.email, isAsc);
    //     case 'role':
    //       return compare(a.role, b.role, isAsc);
    //     default:
    //       return 0;
    //   }
    // });
   }
 
}
  function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}