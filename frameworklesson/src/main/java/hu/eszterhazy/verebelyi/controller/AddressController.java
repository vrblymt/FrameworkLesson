package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.Address.Address;
import hu.eszterhazy.verebelyi.api.Address.AddressQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressQueryService addressQueryService;

    @RequestMapping(value={"", "/", "/{address}"})
    public Collection<Address> findAll(
            @PathVariable(name = "address", required = false) String address) {

        if(address != null){
            try{
                return addressQueryService.findAddressById(Long.decode(address));
            }
            catch(NumberFormatException ex){
                return addressQueryService.findByAddress(address);
            }
        }else{
            return addressQueryService.allAddress();
        }
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void addNewAddress(
            @RequestParam(name = "address", required = true) String address,
            @RequestParam(name = "district", required = true) String district,
            @RequestParam(name="cityId", required = true) String cityId,
            @RequestParam(name="postalcode", required = true) String postalcode,
            @RequestParam(name="phone", required =  true) String phone)
    {
        Long city = Long.decode(cityId);
        Date date = new Date();
        addressQueryService.addAddress(new Address(address, district, city, postalcode, phone, new Timestamp(date.getTime())));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public void modifyAddress(
            @RequestParam(name = "id", required = true) String id,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "address2", required = false) String address2,
            @RequestParam(name = "district", required = false) String district,
            @RequestParam(name = "cityId", required = false) Long cityId,
            @RequestParam(name = "postalCode", required = false) String postalCode,
            @RequestParam(name = "phone", required = false) String phone
    ){
        addressQueryService.modifyAddress(Long.decode(id), address, address2, district, cityId, postalCode, phone);
    }


    @Transactional
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public void deleteAddress(
            @RequestParam(name="id", required = true) Long id
    ){
        addressQueryService.deleteAddress(id);
    }
}
