import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/domain/login';
import { User } from 'src/app/domain/user';
import { IdentityService } from 'src/app/services/identity.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  user: Login = new Login('', '');
  loggedIn = false;
  logInFailed = false;

  constructor(
    private _identityService: IdentityService,
    private _router: Router
  ) {}

  ngOnInit(): void {}

  login() {
    let loggedInUser = this._identityService.login(
      this.user.userName,
      this.user.password
    );
    if (loggedInUser) {
      this._router.navigate(['/dashboard']);
    } else {
      this.loggedIn = true;
      this.logInFailed = true;
    }
  }
}
