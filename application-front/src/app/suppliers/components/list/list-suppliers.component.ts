import { Component, OnInit } from '@angular/core';
import { SuppliersService, Supplier } from '../../services';

@Component({
  selector: 'app-list-suppliers',
  templateUrl: './list-suppliers.component.html',
  styleUrls: ['./list-suppliers.component.css']
})
export class ListSuppliersComponent implements OnInit {

  suppliers: Supplier[] = [];

  constructor(private supplierService: SuppliersService) {}

  ngOnInit(): void {
    this.listAll();
  }

  listAll() {
    this.supplierService.listAll().subscribe(
      data => {
        this.suppliers = data;
      }
    );
  }

  delete(supplier: Supplier): void {
    this.supplierService.delete(supplier.id).subscribe(
      data => {
        console.log(data)
        this.listAll();
      },
      (error) => {
        if(error.error.includes("ERROR101")){
          alert("Necessario remover a relação entre fornecedor e empresa para realizar a deleção.");
        }
      }
    );
  }

  supplierType(supplier: Supplier) {
    if(supplier.supplierType == 0) {
      return "F";
    }
    return "J";
  }
}