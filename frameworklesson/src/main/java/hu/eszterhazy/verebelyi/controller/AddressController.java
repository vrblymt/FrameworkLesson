package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.Address.Address;
import hu.eszterhazy.verebelyi.api.Address.AddressQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressQueryService addressQueryService;

    @RequestMapping(value={"", "/", "/{addressId}"})
    public Collection<Address> findAll(
            @PathVariable(name = "addressId", required = false) Long id) {

        if (id == null || "".equals(id)) {
            return addressQueryService.allAddress();
        }
        return addressQueryService.findAddressById(id);
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void addNewAddress(
            @RequestParam(name = "address", required = true) String address,
            @RequestParam(name = "district", required = true) String district,
            @RequestParam(name="cityId", required = true) String cityId,
            @RequestParam(name="postalcode", required = true) String postalcode,
            @RequestParam(name="phone", required =  true) String phone){
        Long city = Long.decode(cityId);
        addressQueryService.addAddress(new Address(address, district, city, postalcode, phone));
    }
    @Transactional
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public void deleteAddress(
            @RequestParam(name="id", required = true) Long id
    ){
        addressQueryService.deleteAddress(id);
    }
}
