import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../domain/user';

const users: User[] = [
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

@Injectable({
  // this is a decorator which tells Angular that this is a service and is available for injection
  providedIn: 'root', // this is the name of the module in which this service is available
})

// POST -> create a new resource
// GET -> retrieve all resources
export class IdentityService {
  constructor(private http: HttpClient) {}

  register(user: User) {}

  login(email: string, password: string) {
    const user = users.find(
      (u) => u.email === email && u.password === password
    );

    if (user) {
      sessionStorage.setItem('loggedInUser', JSON.stringify(user));
      return user;
    }
    return null;
  }

  getLoggedInUser() {
    let user =  JSON.parse(sessionStorage.getItem('loggedInUser')!);
    return user ? true : false;
  }
}
