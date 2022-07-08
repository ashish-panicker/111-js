import { Component, OnInit } from '@angular/core';
import { Login } from 'src/app/domain/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  
  user:Login = new Login('', '');

  constructor() {}

  ngOnInit(): void {}

  login() {
    console.log('login form submitted');
    console.log(this.user);
  }
}
