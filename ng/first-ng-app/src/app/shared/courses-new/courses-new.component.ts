import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CourseService } from 'src/app/services/course.service';
import { IdentityService } from 'src/app/services/identity.service';

@Component({
  selector: 'app-courses-new',
  templateUrl: './courses-new.component.html',
  styleUrls: ['./courses-new.component.css'],
})
export class CoursesNewComponent implements OnInit {
  constructor(
    private _courseService: CourseService,
    private _identityService: IdentityService,
    private _router: Router,
    private _fb: FormBuilder
  ) {}

  ngOnInit(): void {}

  courseForm = this._fb.group({
    code: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(5)]],
    title: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
    description: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(500)]],
    topics: ['', [Validators.required, Validators.minLength(3)]],
  })
}
