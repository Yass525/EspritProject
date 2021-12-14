import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StocktableRoComponent } from './stocktablero.component';

describe('StocktableComponent', () => {
  let component: StocktableRoComponent;
  let fixture: ComponentFixture<StocktableRoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StocktableRoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StocktableRoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
