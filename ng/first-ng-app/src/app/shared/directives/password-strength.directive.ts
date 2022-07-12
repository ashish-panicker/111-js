import { Directive } from '@angular/core';
import {
  AbstractControl,
  NG_VALIDATORS,
  ValidationErrors,
  Validator,
} from '@angular/forms';
import { CustomValidators } from 'src/app/shared/validators/custom-validators';

@Directive({
  selector: '[appPasswordStrength]',
  providers: [
    {
      provide: NG_VALIDATORS,
      useExisting: PasswordStrengthDirective,
      multi: true,
    },
  ],
})
export class PasswordStrengthDirective implements Validator {
  constructor() {}

  validate(control: AbstractControl): ValidationErrors | null {
    const value = control.value;
    console.log(control);
    return CustomValidators.passwordStrength(control);
  }
}
