import { Component, OnInit } from '@angular/core';
import { CompaniesService, Company } from '../../services';
import { Supplier } from 'src/app/suppliers';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-company-suppliers',
  templateUrl: './list-company-suppliers.component.html',
  styleUrls: ['./list-company-suppliers.component.css']
})
export class ListCompanySuppliersComponent implements OnInit {

  company: Company = new Company();

  constructor(private companyService: CompaniesService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    const companyId = this.route.snapshot.params["id"];
    this.findById(companyId);
  }

  findById(id: string) {
    this.companyService.findById(id).subscribe(
      data => {
        this.company = data;
      }
    );
  }

  getDocument(supplier: Supplier) {
    return supplier.supplierType == 0 ? supplier.cpf : supplier.cnpj;
  }

  delete(supplier: Supplier) {
    for(let sup of this.company.suppliers) {
      if(sup.id == supplier.id) {
        const index = this.company.suppliers.indexOf(sup);
        this.company.suppliers.splice(index, 1);
      }
    }

    this.companyService.insert(this.company).subscribe(
      data => {
        this.findById(data.id);
      }
    );
  }
}