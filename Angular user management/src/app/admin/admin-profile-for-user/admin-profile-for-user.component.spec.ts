import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProfileForUserComponent } from './admin-profile-for-user.component';

describe('AdminProfileForUserComponent', () => {
  let component: AdminProfileForUserComponent;
  let fixture: ComponentFixture<AdminProfileForUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminProfileForUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProfileForUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
