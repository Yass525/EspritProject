import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersListPaginatedComponent } from './users-list-paginated.component';

describe('UsersListPaginatedComponent', () => {
  let component: UsersListPaginatedComponent;
  let fixture: ComponentFixture<UsersListPaginatedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsersListPaginatedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersListPaginatedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
