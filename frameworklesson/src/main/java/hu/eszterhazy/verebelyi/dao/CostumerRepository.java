package hu.eszterhazy.verebelyi.dao;

import hu.eszterhazy.verebelyi.api.Costumer.Costumer;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface CostumerRepository extends CrudRepository<Costumer, Long> {
    List<Costumer> findByIdEquals(Long id);
    List<Costumer> findByFirstNameContainsOrLastNameContains(String name, String name1);
    void deleteByIdEquals(Long id);
}
