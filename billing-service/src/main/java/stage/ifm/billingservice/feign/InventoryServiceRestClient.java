package stage.ifm.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import stage.ifm.billingservice.model.Customer;
import stage.ifm.billingservice.model.Product;

@FeignClient(name = "inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "inventory-service", fallbackMethod = "getDefaultProduct")
    Product getProduct(@PathVariable Long id);

    default Product getDefaultProduct(Long id, Exception e){
        return  Product.builder().id(id).build();
    }
}
