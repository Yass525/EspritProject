import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogtableComponent } from './logtable.component';
describe('StocktableComponent', () => {
  let component: LogtableComponent;
  let fixture: ComponentFixture<LogtableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogtableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LogtableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
