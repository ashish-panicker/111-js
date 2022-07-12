import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IdentityService } from 'src/app/services/identity.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private _router: Router, private _identityService: IdentityService) { }

  ngOnInit(): void {
  }

  logout(){
    this._identityService.logout();
    this._router.navigate(['']);
  }

  isLoggedInUser(){
    return this._identityService.isUserLoggedIn();
  }

  isLoggedInAdmin(){
    return this.isLoggedInUser() && this._identityService.isAdminLoggedIn();
  }

  navigateTo(route: string){
    switch(route){
      case 'home':
        this._router.navigate(['']);
        break;
      case 'courses':
        this._router.navigate(['/courses']);
        break;
    }

  }
}
