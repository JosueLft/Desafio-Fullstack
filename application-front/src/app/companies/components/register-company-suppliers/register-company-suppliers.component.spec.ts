import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterCompanySuppliersComponent } from './register-company-suppliers.component';

describe('RegisterCompanySuppliersComponent', () => {
  let component: RegisterCompanySuppliersComponent;
  let fixture: ComponentFixture<RegisterCompanySuppliersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterCompanySuppliersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterCompanySuppliersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
