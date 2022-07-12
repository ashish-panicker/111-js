import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IdentityService } from 'src/app/services/identity.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css'],
})
export class LandingComponent implements OnInit {
  constructor(
    private _identityService: IdentityService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    if (this._identityService.isUserLoggedIn()) {
      this._router.navigate(['/dashboard']);
    }
  }
}
