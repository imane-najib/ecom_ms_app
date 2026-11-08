
import { Component, OnInit } from '@angular/core';
import { AsyncPipe, CommonModule } from '@angular/common';
import { catchError, map, Observable, of } from 'rxjs';
import { CustomerService } from '../services/customer-service';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Customer } from '../model/customer';

@Component({
  selector: 'app-customers',
  imports: [ReactiveFormsModule, CommonModule, AsyncPipe],
  templateUrl: './customers.html',
  styleUrl: './customers.css',
})
export class Customers implements OnInit {

  customers!: Observable<Array<Customer>>;

  constructor(private customerService: CustomerService) {}

  ngOnInit(): void {
    this.customers = this.customerService.getCustomers();
  }
}
