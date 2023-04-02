import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { SuppliersService } from './services';
import { ListSuppliersComponent } from './components/list/list-suppliers.component';
import { RegisterSupplierComponent } from './components/register/register-supplier.component';

@NgModule({
  declarations: [
    ListSuppliersComponent,
    RegisterSupplierComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    SuppliersService
  ]
})
export class SuppliersModule { }