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
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteAddressByIdEquals(id);
    }
}
