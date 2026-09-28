package stage.ifm.billingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import stage.ifm.billingservice.model.Customer;

@FeignClient(name = "customer-service")
public interface CustomerServiceRestClient {
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
}
