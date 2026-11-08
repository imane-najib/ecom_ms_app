import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { Customer } from '../model/customer';
import {CustomerResponse} from '../model/custumerResponse';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  backendHost: string = 'http://localhost:8888/CUSTOMER-SERVICE';
  constructor(private http: HttpClient) {}

  public getCustomers(): Observable<Array<Customer>> {
    return this.http.get<CustomerResponse>(this.backendHost + '/customers').pipe(
      map(data => data._embedded.customers)
      );
  }







}
