import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'first-ng-app';
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