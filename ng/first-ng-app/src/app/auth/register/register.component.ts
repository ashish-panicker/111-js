import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/domain/user';
import { IdentityService } from 'src/app/services/identity.service';

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

  // identiyService instance is injected into the constructor by Angular
  // this is called as dependency injection
  constructor(private identityService: IdentityService) {}

  ngOnInit(): void {}

  register() {
    console.log('register form submitted');
    console.log(this.registerForm.value);

    let user = this.registerForm.value as User;
    user.role = 'user';
    this.identityService.register(user).subscribe((data) => console.log(data));

    // TODO: validate the password and confirm password
    // TODO: copy the form data to the server using services
  }
}
