import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment as env } from 'src/environments/environment';
import { CepModel } from "src/app/utils/cep.model";

import { Supplier, SuppliersService } from '../../services';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-supplier',
  templateUrl: './register-supplier.component.html',
  styleUrls: ['./register-supplier.component.css']
})
export class RegisterSupplierComponent implements OnInit {

  @ViewChild("formSupplier") formSupplier: NgForm;
  supplier: Supplier;

  cepOrigin: string;
  cepModel: CepModel;
  uf: string = "";

  constructor(private supplierService: SuppliersService, private router: Router, private http: HttpClient){}

  ngOnInit(): void {
    this.cepOrigin = null;
    this.supplier = new Supplier();
  }

  reigster() {
    if(this.supplier.supplierType == 0 && this.isFromParana() && this.isUnderage()) {
      alert("Fornecedores que residam no Parana devem possuir mais de 18 anos para poderem se cadastrar!")
    }

    if(this.formSupplier.form.invalid) {
      return;
    }

    this.supplierService.insert(this.supplier).subscribe(
      supplier => alert("Fornecedor " + supplier.name + "cadastrado com sucesso!"),
      () => alert("Erro cadastrando fornecedor!")
    );
  }

  findCEP(cep: string) {
    this.validateCEP(cep);
  }

  validateCEP(cep: string) {
    var xhr = new XMLHttpRequest();
    xhr.open ("GET", "http://cep.la/" + cep, true);
    xhr.setRequestHeader ("Accept", "application/json");
    xhr.onreadystatechange = () => {
      if((xhr.readyState == 0 || xhr.readyState == 4) && xhr.status == 200) {
        this.cepModel = JSON.parse(xhr.responseText) as CepModel;
        this.uf = this.cepModel.uf;
      }
    };
    xhr.send();
  }

  isFromParana(): boolean {
    return this.uf == "PR" || this.uf == "pr";
  }

  isUnderage(): boolean {
    const today = new Date();
    const birth = new Date(this.supplier.birthDate);
    let age = today.getFullYear() - birth.getFullYear();
    const monthDiff = today.getMonth() - birth.getMonth();
    if(monthDiff < 0 || (monthDiff === 0 && today.getDate() < birth.getDate())) {
      age--;
    }
    return age < 18;
  }
}