package hu.eszterhazy.verebelyi.api.Address;

import java.sql.Timestamp;
import java.util.Collection;

public interface AddressQueryService {
    Collection<Address> allAddress();
    Collection<Address> findAddressById(Long id);
    Collection<Address> findByAddress(String address);
    void addAddress(Address address);
    void deleteAddress(Long id);
    void modifyAddress(Long id, String address, String address2, String district, Long cityId, String postalcode, String phone);
}
