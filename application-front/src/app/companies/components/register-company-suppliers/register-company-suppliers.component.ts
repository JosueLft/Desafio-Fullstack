import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { CompaniesService, Company } from '../../services';
import { Supplier, SuppliersService } from 'src/app/suppliers';

@Component({
  selector: 'app-register-company-suppliers',
  templateUrl: './register-company-suppliers.component.html',
  styleUrls: ['./register-company-suppliers.component.css']
})
export class RegisterCompanySuppliersComponent implements OnInit {

  suppliers: Supplier[] = [];
  company: Company;
  companyId: string;

  constructor(private companyService: CompaniesService,
              private supplierService: SuppliersService,
              private router: Router,
              private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.companyId = this.route.snapshot.params["id"];
    this.findAllSuppliers();
  }

  findAllSuppliers() {
    this.supplierService.listAll().subscribe(
      data => {
        this.suppliers = data;
        this.companyService.findById(this.companyId).subscribe(
          data => {
            this.company = data;
          }
        );
      }
    );
  }

  toHire(supplier: Supplier) {
    this.companyService.insertSuppliers(supplier.id.toString(), this.companyId).subscribe(
      data => {
      }
    );
  }
}