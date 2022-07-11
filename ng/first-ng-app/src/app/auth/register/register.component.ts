import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  registerForm = new FormGroup({
    userName: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(15),
      Validators.email,
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
    ]),
    confirmPassword: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
    ]),
  });

  constructor() {}

  ngOnInit(): void {}

  register() {
    console.log('register form submitted');
    console.log(this.registerForm.value);
    // TODO: validate the password and confirm password
    // TODO: copy the form data to the server using services
  }

  
}
