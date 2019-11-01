package hu.eszterhazy.verebelyi.api.Address;

import java.util.Collection;

public interface AddressQueryService {
    Collection<Address> allAddress();
    Collection<Address> findAddressById(Long id);
    void addAddress(Address address);
    void deleteAddress(Long id);
}
