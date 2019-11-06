package hu.eszterhazy.verebelyi.controller;

import hu.eszterhazy.verebelyi.api.Category.Category;
import hu.eszterhazy.verebelyi.api.Category.CategoryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryQueryService categoryQueryService;

    @RequestMapping(value={"", "/", "/{category}"})
    public Collection<Category> listAllCategory(
            @PathVariable(name = "category", required = false) String category
    ){
        if(category != null){
            try{
                return categoryQueryService.findById(Long.decode(category));
            }
            catch(NumberFormatException ex){
                return categoryQueryService.findByName(category);
            }
        }else{
            return categoryQueryService.listAll();
        }
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void addNewCategory(
            @RequestParam(name="category", required = true) String name
    ){
        Date date = new Date();
        Category category = new Category();
        category.setName(name);
        category.setLast_update(new Timestamp(date.getTime()));
        categoryQueryService.addNewCategory(category);
    }

    @RequestMapping(value="/modify", method = RequestMethod.POST)
    public void addNewCategory(
            @RequestParam(name= "id", required = true) Long id,
            @RequestParam(name = "name", required = true)String name
    ){
        categoryQueryService.modifyCategory(id, name);
    }

    @Transactional
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public void deleteCategory(
            @RequestParam(name="id", required = true) Long id
    ){
        categoryQueryService.deleteCategoryById(id);
    }
}
