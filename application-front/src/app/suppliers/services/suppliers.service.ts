import { Injectable } from '@angular/core';
import { Supplier } from './supplier.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment as env } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SuppliersService {

  private readonly resource = "/suppliers"

  supplier: Supplier;

  constructor(private http: HttpClient) { }

  listAll(): Observable<any> {
    return this.http.get(
      env.apiUrlBase + this.resource
    );
  }

  insert(supplier: Supplier): Observable<any> {
    return this.http.post(
      env.apiUrlBase + this.resource,
      supplier
    );
  }

  delete(id: number): Observable<any> {
    return this.http.delete(
      env.apiUrlBase + this.resource + "/" + id
    );
  }
}