import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ListCompaniesComponent } from './components/list/list-companies.component';
import { CompaniesService } from './services';
import { RegisterCompanyComponent } from './components/register/register-company.component';
import { ListCompanySuppliersComponent } from './components/list-company-suppliers/list-company-suppliers.component';
import { RegisterCompanySuppliersComponent } from './components/register-company-suppliers/register-company-suppliers.component';

@NgModule({
  declarations: [
    ListCompaniesComponent,
    RegisterCompanyComponent,
    ListCompanySuppliersComponent,
    RegisterCompanySuppliersComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    CompaniesService
  ]
})
export class CompaniesModule { }
