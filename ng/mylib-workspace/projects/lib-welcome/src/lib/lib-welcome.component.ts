import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'lib-lib-welcome',
  template: `
    <p>
      Welcome Library Works
    </p>
  `,
  styles: [
  ]
})
export class LibWelcomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
