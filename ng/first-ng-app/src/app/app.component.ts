import { Component } from '@angular/core';
import { Course } from './domain/course';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'first-ng-app';

  courses: Course[] = [
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

/**
 * Angular Component is a Typescript class that is used to create a html view in Angular.
 * They have the @Component decorator that is used to mark them as a component.
 * They have a selector property that is used to select the component in the html file.
 * They have a template property that is used to define the html view.
 * They have a templateUrl property that is used to define the html file. You can use either the
 * template or templateUrl property to define the html view.
 * They have a styleUrls property that is used to define the css file.
 * They have a providers property that is used to define the services that are used in the component.
 */
