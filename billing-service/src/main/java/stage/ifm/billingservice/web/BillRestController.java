package stage.ifm.billingservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stage.ifm.billingservice.entities.Bill;
import stage.ifm.billingservice.feign.CustomerServiceRestClient;
import stage.ifm.billingservice.feign.InventoryServiceRestClient;
import stage.ifm.billingservice.repository.BillRepository;
import stage.ifm.billingservice.repository.ProductItemRepository;

@RestController
@RequestMapping("/api")
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient InventoryServiceRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerServiceRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(InventoryServiceRestClient.getProduct(productItem.getProductId()));
        });
        return bill;
    }

}
