import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'lib-header',
  template: `
    <h1>
      This is the Library Header Componenet for the header library.
    </h1>
  `,
  styles: [
  ]
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
