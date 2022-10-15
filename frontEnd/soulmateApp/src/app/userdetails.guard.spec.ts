import { TestBed } from '@angular/core/testing';

import { UserdetailsGuard } from './userdetails.guard';

describe('UserdetailsGuard', () => {
  let guard: UserdetailsGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(UserdetailsGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
