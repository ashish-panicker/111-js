import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../domain/user';

const API_URL = 'http://localhost:3000/users';

@Injectable({ // this is a decorator which tells Angular that this is a service and is available for injection
  providedIn: 'root' // this is the name of the module in which this service is available
})

// POST -> create a new resource
// GET -> retrieve all resources
export class IdentityService {

  constructor(private http: HttpClient) { }

  register(user: User) {
    console.log('registering...');
    console.log(user);
    return this.http.post(API_URL, user);
  }
}
