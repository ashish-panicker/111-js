import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from 'src/app/domain/course';
import { CourseService } from 'src/app/services/course.service';
import { IdentityService } from 'src/app/services/identity.service';

@Component({
  selector: 'app-courses-list',
  templateUrl: './courses-list.component.html',
  styleUrls: ['./courses-list.component.css'],
})
export class CoursesListComponent implements OnInit {
  courses: Course[] = [];
  constructor(
    private _courseService: CourseService,
    private _identityService: IdentityService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    if (!this._identityService.isUserLoggedIn()) {
      this._router.navigate(['']);
      return;
    }
    this.courses = this._courseService.getCourses();
  }
}
