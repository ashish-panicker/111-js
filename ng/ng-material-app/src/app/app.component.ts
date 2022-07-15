import { Component } from '@angular/core';
import { User } from './domain/user';

const USERS_DATA: User[] = [
  {
    id: 1,
    email: 'admin@velocity',
    password: 'admin',
    role: 'admin',
  },
  {
    id: 2,
    email: 'user@velocity',
    password: 'user',
    role: 'user',
  },
];

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'ng-material-app';
  longText =
    'The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog from Japan. A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was originally bred for hunting. ';
  data = USERS_DATA;
  columns: string[] = ['id', 'email', 'password', 'role'];
}
