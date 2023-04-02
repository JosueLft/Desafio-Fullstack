import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment as env } from 'src/environments/environment';
import { Company } from "./company.model";

@Injectable({
  providedIn: 'root'
})
export class CompaniesService {

  private readonly resource = "/companies"

  constructor(private http: HttpClient) { }

  listAll(): Observable<any> {
    return this.http.get(
      env.apiUrlBase + this.resource
    );
  }

  findById(id: string): Observable<any> {
    return this.http.get(
      env.apiUrlBase + this.resource + "/" + id
    );
  }

  insert(company: Company): Observable<any> {
    return this.http.post(
      env.apiUrlBase + this.resource,
      company
    );
  }

  insertSuppliers(idList: string, companyId: string): Observable<any> {
    return this.http.post(
      env.apiUrlBase + this.resource + "/" + companyId + "/insert-suppliers",
      [idList]
    );
  }

  delete(id: number): Observable<any> {
    return this.http.delete(
      env.apiUrlBase + this.resource + "/" + id
    );
  }
}