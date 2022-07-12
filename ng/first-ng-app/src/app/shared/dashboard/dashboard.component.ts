import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/domain/course';
import { CourseService } from 'src/app/services/course.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  courses: Course[] = []
  constructor(private _courseService: CourseService) { }

  ngOnInit(): void {
    this.courses = this._courseService.getCourses()
  }

}
