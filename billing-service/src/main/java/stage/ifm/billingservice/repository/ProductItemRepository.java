package stage.ifm.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stage.ifm.billingservice.entities.ProductItem;
import stage.ifm.billingservice.model.Product;

import java.util.List;
@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    List<ProductItem> findByBillId(Product billId);
}
