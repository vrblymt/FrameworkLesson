package hu.eszterhazy.verebelyi.dao;

import hu.eszterhazy.verebelyi.api.Address.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAddressByIdEquals(Long id);
    void deleteAddressByIdEquals(Long id);
}
