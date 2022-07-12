import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/domain/user';
import { IdentityService } from 'src/app/services/identity.service';
import { CustomValidators } from 'src/app/shared/validators/custom-validators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  registerForm = new FormGroup(
    {
      userName: new FormControl('', [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(50),
        Validators.email,
      ]),
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(12),
        CustomValidators.passwordStrength,
      ]),
      confirmPassword: new FormControl('', [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(12),
      ]),
    },
    CustomValidators.passwordMatch
  );

  constructor() {}

  ngOnInit(): void {}

  register() {
    console.log('register');
  }
}
