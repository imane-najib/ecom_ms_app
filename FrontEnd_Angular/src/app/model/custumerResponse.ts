import {Customer} from './customer';

export interface CustomerResponse {
  _embedded: {
    customers: Customer[];
  };
}
