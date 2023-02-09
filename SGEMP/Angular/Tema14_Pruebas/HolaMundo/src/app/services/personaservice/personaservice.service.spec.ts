import { TestBed } from '@angular/core/testing';

import { PersonaserviceService } from './personaservice.service';

describe('PersonaserviceService', () => {
  let service: PersonaserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PersonaserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
