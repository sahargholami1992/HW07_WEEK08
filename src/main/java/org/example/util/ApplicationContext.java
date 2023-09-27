package org.example.util;

import org.example.repository.*;
import org.example.repository.impl.*;
import org.example.service.*;
import org.example.service.impl.*;


public class ApplicationContext {
    private static final ApplicationContext applicationContext = new ApplicationContext();
    private UserRepository userRepository;
    private BrandRepository brandRepository;
    private ShareholderRepository shareholderRepository;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private UserService userService;
    private BrandService brandService;
    private ShareholderService shareholderService;
    private CategoryService categoryService;
    private ProductService productService;
    private ShareholderBrandService shareholderBrandService;
    private ShareholderBrandRepository shareholderBrandRepository;

    public ApplicationContext() {
    }
    public static ApplicationContext getInstance() {
        return applicationContext;
    }
    public UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return userRepository;
    }

    public UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(
                    getUserRepository()
            );
        }
        return userService;
    }
    public BrandRepository getBrandRepository() {
        if (brandRepository == null) {
            brandRepository = new BrandRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return brandRepository;
    }

    public BrandService getBrandService() {
        if (brandService == null) {
            brandService = new BrandServiceImpl(
                    getBrandRepository()
            );
        }
        return brandService;
    }
    public ShareholderRepository getShareholderRepository() {
        if (shareholderRepository == null) {
            shareholderRepository = new ShareholderRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return shareholderRepository;
    }

    public ShareholderService getShareholderService() {
        if (shareholderService == null) {
            shareholderService = new ShareholderServiceImpl(
                    getShareholderRepository()
            );
        }
        return shareholderService;
    }
    public ProductRepository getProductRepository() {
        if (productRepository == null) {
            productRepository = new ProductRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return productRepository;
    }

    public ProductService getProductService() {
        if (productService == null) {
            productService = new ProductServiceImpl(
                    getProductRepository()
            );
        }
        return productService;
    }
    public CategoryRepository getCategoryRepository() {
        if (categoryRepository == null) {
            categoryRepository = new CategoryRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return categoryRepository;
    }

    public CategoryService getCategoryService() {
        if (categoryService == null) {
            categoryService = new CategoryServiceImpl(
                    getCategoryRepository()
            );
        }
        return categoryService;
    }
    public ShareholderBrandRepository getShareholderBrandRepository() {
        if (shareholderBrandRepository == null) {
            shareholderBrandRepository = new ShareholderBrandRepositoryImpl(
                    DataSource.getConnection()
            );
        }
        return shareholderBrandRepository;
    }

    public ShareholderBrandService getShareholderBrandService() {
        if (shareholderBrandService == null) {
            shareholderBrandService = new ShareholderBrandServiceImpl(
                    getShareholderBrandRepository()
            );
        }
        return shareholderBrandService;
    }


}
