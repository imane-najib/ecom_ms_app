package stage.ifm.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import stage.ifm.billingservice.entities.Bill;
@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {
}
