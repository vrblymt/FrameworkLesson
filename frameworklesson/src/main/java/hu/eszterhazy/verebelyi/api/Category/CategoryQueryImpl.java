package hu.eszterhazy.verebelyi.api.Category;

import hu.eszterhazy.verebelyi.dao.CategoryRepository;

import java.util.Collection;

public class CategoryQueryImpl implements CategoryQueryService {
    private CategoryRepository categoryRepository;
    public CategoryQueryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Collection<Category> listAll() {
        return (Collection<Category>) categoryRepository.findAll();
    }

    @Override
    public Collection<Category> findById(Long id) {
        return categoryRepository.findByIdEquals(id);
    }

    @Override
    public Collection<Category> findByName(String name) {
        return categoryRepository.findByNameContains(name);
    }

    @Override
    public void addNewCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteByIdEquals(id);
    }
}
