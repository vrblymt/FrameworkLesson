package hu.eszterhazy.verebelyi.api.Costumer;

import hu.eszterhazy.verebelyi.dao.CostumerRepository;

import java.util.Collection;

public class CostumerQueryImpl implements CostumerQueryService {

    private CostumerRepository costumerRepository;

    public CostumerQueryImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @Override
    public Collection<Costumer> listAll() {
        return (Collection<Costumer>) costumerRepository.findAll();
    }

    @Override
    public Collection<Costumer> findById(Long id) {
        return costumerRepository.findByIdEquals(id);
    }

    @Override
    public Collection<Costumer> findByName(String name) {
        return costumerRepository.findByFirstNameContainsOrLastNameContains(name, name);
    }

    @Override
    public void addCustomer(Costumer costumer) {
        costumerRepository.save(costumer);
    }

    @Override
    public void modifyCustomer(Long id, Long storeId,String firstName, String lastName, String email, Long addressId, Integer active) {
        Costumer costumer = costumerRepository.findByIdEquals(id).get(0);
        if(storeId != null) costumer.setStoreId(storeId);
        if(firstName != null) costumer.setFirstName(firstName);
        if(lastName != null) costumer.setLastName(lastName);
        if(email != null) costumer.setEmail(email);
        if(addressId != null) costumer.setAddressId(addressId);
        if(active != null) costumer.setActive(active);
        costumerRepository.save(costumer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        costumerRepository.deleteByIdEquals(id);
    }
}
