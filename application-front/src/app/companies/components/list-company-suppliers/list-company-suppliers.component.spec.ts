import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCompanySuppliersComponent } from './list-company-suppliers.component';

describe('ListCompanySuppliersComponent', () => {
  let component: ListCompanySuppliersComponent;
  let fixture: ComponentFixture<ListCompanySuppliersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCompanySuppliersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListCompanySuppliersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
