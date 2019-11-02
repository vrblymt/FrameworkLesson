package hu.eszterhazy.verebelyi.dao;

import hu.eszterhazy.verebelyi.api.Category.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByIdEquals(Long id);
    List<Category> findByNameContains(String name);
    void deleteByIdEquals(Long id);
}
