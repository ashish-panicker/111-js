import {
  AbstractControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
} from '@angular/forms';

export class CustomValidators {
  constructor() {}

  static passwordMatch(control: AbstractControl): ValidationErrors | null {
    const password = control.get('password')!.value;
    const confirmPassword = control.get('confirmPassword')!.value;
    if (password !== confirmPassword) {
      control.get('confirmPassword')!.setErrors({ passwordMatch: true });
      return { passwordMatch: true };
    }
    return null;
  }

  static passwordStrength(control: AbstractControl): ValidationErrors | null {
    const value = control.value;

    const hasUpperCase = value.match(/[A-Z]/);

    const hasLowerCase = value.match(/[a-z]/);

    const hasNumber = value.match(/[0-9]/);

    const hasSpecialCharacter = value.match(
      /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/
    );

    const passwordValid =
      hasUpperCase && hasLowerCase && hasNumber && hasSpecialCharacter;

    return !passwordValid ? { passwordStrength: true } : null;
  }
}
