package org.example;

import org.example.base.domain.BaseEntity;
import org.example.domain.Category;
import org.example.menue.Menu;
import org.example.repository.CategoryRepository;
import org.example.repository.impl.CategoryRepositoryImpl;
import org.example.service.CategoryService;
import org.example.util.ApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.publicMenu();
//        CategoryRepository categoryRepository = ApplicationContext.getInstance().getCategoryRepository();
//        CategoryService categoryService = ApplicationContext.getInstance().getCategoryService();
//        BaseEntity[] all = categoryService.findAll();
//        for (int i = 0; i < all.length; i++) {
//            System.out.println(all[i]);
//        }
    }
}