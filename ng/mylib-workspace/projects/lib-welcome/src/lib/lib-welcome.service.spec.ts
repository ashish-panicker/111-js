import { TestBed } from '@angular/core/testing';

import { LibWelcomeService } from './lib-welcome.service';

describe('LibWelcomeService', () => {
  let service: LibWelcomeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LibWelcomeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
