package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.Costumer.Costumer;
import hu.eszterhazy.verebelyi.api.Costumer.CostumerQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value = "/customers")
public class CostumerController {
    @Autowired
    private CostumerQueryService costumerQueryService;

    @RequestMapping(value = {"", "/", "/{customer}"})
    public Collection<Costumer> findCostumer(
            @PathVariable(name = "customer", required = false) String costumer
    ){
        if(costumer != null){
            try{
                return costumerQueryService.findById(Long.decode(costumer));
            }
            catch(NumberFormatException ex){
                return costumerQueryService.findByName(costumer);
            }
        }else{
            return costumerQueryService.listAll();
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addNewCustomer(
            @RequestParam(name = "storeId", required = true) Long storeId,
            @RequestParam(name = "firstName", required = true) String firstName,
            @RequestParam(name = "lastName", required = true) String lastName,
            @RequestParam(name = "email", required = true) String email,
            @RequestParam(name = "addressId", required = true) Long addressId,
            @RequestParam(name = "active", required = true) Integer active
    ){
        if(active == 1 || active == 0){
            Date date = new Date();
            costumerQueryService.addCustomer(new Costumer(storeId, firstName, lastName, email, addressId, active,new Timestamp(date.getTime()), new Timestamp(date.getTime())));
        }
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public void modifyCustomer(
            @RequestParam(name = "id", required = true) Long id,
            @RequestParam(name = "storeId", required = false) Long storeId,
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "addressId", required = false) Long addressId,
            @RequestParam(name = "active", required = false) Integer active
    ){
        costumerQueryService.modifyCustomer(id, storeId, firstName, lastName, email, addressId, active);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteCostumer(
            @RequestParam(name = "id", required = true) Long id){
        costumerQueryService.deleteCustomerById(id);
    }
}
