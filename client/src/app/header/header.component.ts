import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  router: string;
  constructor(private _router: Router) {
    this.router = _router.url; 
   }

  ngOnInit(): void {
  }

}
