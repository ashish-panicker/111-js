import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibWelcomeComponent } from './lib-welcome.component';

describe('LibWelcomeComponent', () => {
  let component: LibWelcomeComponent;
  let fixture: ComponentFixture<LibWelcomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibWelcomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LibWelcomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
