package hu.eszterhazy.verebelyi.api.Costumer;

import java.util.Collection;

public interface CostumerQueryService {
    Collection<Costumer> listAll();
    Collection<Costumer> findById(Long id);
    Collection<Costumer> findByName(String name);
    void addCustomer(Costumer costumer);
    void modifyCustomer(Long id, Long storeId,String firstName, String lastName, String email, Long addressId, Integer active);
    void deleteCustomerById(Long id);
}
