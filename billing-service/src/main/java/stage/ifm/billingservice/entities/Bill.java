package stage.ifm.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import stage.ifm.billingservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue
    private Long id;
    private Date billingDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")

    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
