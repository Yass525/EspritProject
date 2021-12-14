import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsulterFactureComponent } from './consulter-facture.component';

describe('ConsulterFactureComponent', () => {
  let component: ConsulterFactureComponent;
  let fixture: ComponentFixture<ConsulterFactureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsulterFactureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsulterFactureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
