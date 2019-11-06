package hu.eszterhazy.verebelyi.api.Category;

import java.util.Collection;

public interface CategoryQueryService {
    Collection<Category> listAll();
    Collection<Category> findById(Long id);
    Collection<Category> findByName(String name);
    void addNewCategory(Category category);
    void modifyCategory(Long id, String name);
    void deleteCategoryById(Long id);
}
