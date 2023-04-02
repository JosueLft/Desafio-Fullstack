import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { CompaniesService, Company } from '../../services';

@Component({
  selector: 'app-register-company',
  templateUrl: './register-company.component.html',
  styleUrls: ['./register-company.component.css']
})
export class RegisterCompanyComponent implements OnInit {
  @ViewChild("formCompany") formCompany: NgForm;
  company: Company;

  constructor(private companyService: CompaniesService, private router: Router) {}

  ngOnInit(): void {
    this.company = new Company();
  }

  register() {
    if(this.formCompany.form.invalid) {
      return;
    }

    this.companyService.insert(this.company).subscribe(
      company => alert("Empresa " + company.tradingName + " cadastradas com sucesso!"),
      () => alert("Erro cadastrando empresa!")
    );
  }
}