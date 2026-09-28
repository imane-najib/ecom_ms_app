package stage.ifm.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import stage.ifm.billingservice.model.Product;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItem {
    @Id @GeneratedValue
    private Long id;
    private Long productId;
    private Integer quantity;
    private Double price;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    @Transient
    private Product product;
}
