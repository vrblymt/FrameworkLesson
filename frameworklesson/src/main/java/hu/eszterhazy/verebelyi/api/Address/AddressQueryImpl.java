package hu.eszterhazy.verebelyi.api.Address;

import hu.eszterhazy.verebelyi.dao.AddressRepository;

import java.util.Collection;

public class AddressQueryImpl implements AddressQueryService {
    private AddressRepository addressRepository;

    public AddressQueryImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Collection<Address> allAddress() {
        return (Collection<Address>) addressRepository.findAll();
    }

    @Override
    public Collection<Address> findAddressById(Long id) {
        return addressRepository.findAddressByIdEquals(id);
    }

    @Override
    public Collection<Address> findByAddress(String address) {
        return addressRepository.findByAddressContains(address);
    }

    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteAddressByIdEquals(id);
    }

    @Override
    public void modifyAddress(Long id, String address1, String address2, String district, Long cityId, String postalcode, String phone) {
        Address address = addressRepository.findAddressByIdEquals(id).get(0);
        if(address1 != null){
            address.setAddress(address1);
        }
        if(address2 != null) {
            address.setAddress2(address2);
        }
        if(district != null) {
            address.setDistrict(district);
        }
        if(cityId != null) {
            address.setCityId(cityId);
        }
        if(postalcode != null) {
            address.setPostalCode(postalcode);
        }
        if(phone != null) {
            address.setPhone(phone);
        }

        addressRepository.save(address);
    }
}
