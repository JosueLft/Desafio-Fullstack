import { Component, OnInit } from '@angular/core';
import { CompaniesService, Company } from '../../services';
import { ListCompanySuppliersComponent } from '../list-company-suppliers';

@Component({
  selector: 'app-list-companies',
  templateUrl: './list-companies.component.html',
  styleUrls: ['./list-companies.component.css']
})
export class ListCompaniesComponent implements OnInit {

  companies: Company[] = [];

  constructor(private companyService: CompaniesService) {}

  ngOnInit(): void {
    this.listAll();
  }

  listAll() {
    this.companyService.listAll().subscribe(
      data => {
        this.companies = data;
      }
    );
  }

  delete(company: Company) {
    this.companyService.delete(company.id).subscribe(
      data => {
        this.listAll();
      }
    );
  }
}