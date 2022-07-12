import { Injectable } from '@angular/core';
import { Course } from '../domain/course';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  constructor() {}

  getCourses(): Course[] {
    return [
      new Course(
        'ANG100',
        'Angular 101',
        'This is a course about getting started with Angular and being able develop rich front ends applications using angular',
        ['Angular', 'Routing', 'Forms']
      ),
      new Course(
        'JFSD01',
        'Java Fullstack Developer',
        'Learn more about the Java Full Stack Developer program. The course is designed to help you get started with the Java programming language and enable you to build a full-stack application developer based on Java.',
        ['Java', 'Spring Boot', 'REST']
      ),
      new Course(
        'JAWS01',
        'Java AWS Developer',
        'Learn more about the Java AWS Developer program. The course is designed to help you get started with the Java programming language and enable you to build a full-stack application developer based on Java.',
        ['Java', 'Spring Boot', 'REST', 'AWS']
      ),
    ];
  }
}
