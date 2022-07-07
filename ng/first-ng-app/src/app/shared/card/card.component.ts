import { Component, Input, OnInit } from '@angular/core';
import { Course } from 'src/app/domain/course';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
})
export class CardComponent implements OnInit {
  @Input() course!: Course;
  @Input() isDark: boolean = false;

  constructor() {}

  ngOnInit(): void {}
}
