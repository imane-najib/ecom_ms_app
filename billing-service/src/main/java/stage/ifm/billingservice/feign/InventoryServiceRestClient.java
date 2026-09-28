package stage.ifm.billingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import stage.ifm.billingservice.model.Product;

@FeignClient(name = "inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Long id);
}
