import { Component, OnInit } from '@angular/core';
import { CourseService } from 'src/app/services/course.service';
import { IdentityService } from 'src/app/services/identity.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  constructor(
    private _courseService: CourseService,
    private _identityService: IdentityService
  ) {}

  ngOnInit(): void {}
  countCourses(): number {
    return this._courseService.getCourseCount();
  }

  countUsers(): number {
    return this._identityService.getUserCount();
  }
}
