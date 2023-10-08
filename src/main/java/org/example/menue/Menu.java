package org.example.menue;

import org.example.base.domain.BaseEntity;
import org.example.domain.*;

import org.example.service.*;
import org.example.util.ApplicationContext;
import org.example.util.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private final Scanner input = new Scanner(System.in);
    private final ShareholderService shareholderService = ApplicationContext.getInstance().getShareholderService();
    private final UserService userService = ApplicationContext.getInstance().getUserService();
    private final BrandService brandService = ApplicationContext.getInstance().getBrandService();
    private final ProductService productService = ApplicationContext.getInstance().getProductService();
    private final CategoryService categoryService = ApplicationContext.getInstance().getCategoryService();




    public Menu() {
    }

    public void publicMenu() throws SQLException {
        System.out.println("***Welcome***");
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("3- Exit");
        System.out.println("Enter your select:");
        int select = input.nextInt();
        input.nextLine();
        switch (select) {
            case 1 -> signIn();
            case 2 -> registerUser();
            case 3 -> System.exit(-1);
            default -> System.out.println("dose not work!");
        }
    }

    public void registerUser() throws SQLException {
        System.out.println("Enter your name:");
        String name = input.nextLine();

        System.out.println("Enter your userName:");
        String userName = input.nextLine();

        System.out.println("Enter your email:");
        String email = null;
        boolean flag = true;
        while (flag) {
            email = input.nextLine();
            if (Validation.isValidEmailWithRegex(email))
                flag = false;
            else
                System.out.println("please enter a valid password");
        }
            System.out.println("Enter your password:");
            String password = null;
            boolean flg = true;
            while (flg) {
                password = input.nextLine();
                if (Validation.isValidPasswordWithRegex(password))
                    flg = false;
                else
                    System.out.println("please enter a valid password");
            }

            User user = new User();
            user.setName(name);
            user.setUserName(userName);
            user.setEmail(email);
            user.setPassword(password);
            userService.register(user);
            System.out.println("you successfully added !");
            publicMenu();
        }
    public void registerBrand() throws SQLException {
        System.out.println("Enter name of brand:");
        String nameOfBrand = input.nextLine();

        System.out.println("Enter website for it:");
        String website = null;
        boolean flag = true;
        while (flag) {
            website = input.nextLine();
            if (Validation.isValidWebsiteWithRegex(website))
                flag = false;
            else
                System.out.println("please enter a valid website");
        }
        System.out.println("Enter description for brand:");
        String description = input.nextLine();

        Brand brand = new Brand();
        brand.setName(nameOfBrand);
        brand.setWebsite(website);
        brand.setDescription(description);
        brandService.register(brand);
    }
    public void registerCategory() throws SQLException {
        System.out.println("Enter name of category:");
        String nameOfCategory = input.nextLine();
        System.out.println("Enter description for category:");
        String description = input.nextLine();


        Category category = new Category(nameOfCategory, description);
        category.setName(nameOfCategory);
        category.setDescription(description);
        categoryService.register(category);
    }
//    public void registerProduct() throws SQLException {
//        System.out.println("Enter name of product:");
//        String nameOfProduct = input.nextLine();
//        System.out.println("Enter create date for product:");
//        String createDate = input.nextLine();
//
//
//        Product product = new Product(nameOfProduct, createDate);
//        productService.register(product);
//    }
    public void addProduct() throws SQLException {
        long categoryNumber= selectCategory();
        long brandNumber = selectBrand();
        if(categoryNumber==-1 || brandNumber==-1){
            System.out.println("invalid category or brand number");
            userOperation();
        }
        else {
            Category productCategory =(Category) categoryService.findById(categoryNumber);
            Brand productBrand = (Brand)brandService.findById(brandNumber);
            System.out.println("product name: ");
            String productName = input.next();
            Product product = new Product();
            product.setName(productName);
            product.setCategory(productCategory);
            product.setBrand(productBrand);
            productService.register(product);
            userOperation();

        }
    }
    public int selectCategory() throws SQLException {
        System.out.println("select a category number: ");
        BaseEntity[]categories = categoryService.findAll();
        for (BaseEntity category:categories){
            System.out.println(category.getId()+" >> "+category.getName());
        }
        int number = input.nextInt();
        input.nextLine();
        boolean validCategoryNumber=false;
        for(BaseEntity category:categories){
            if(category.getId()==number) {
                validCategoryNumber=true;
                break;
            }
        }
        if(validCategoryNumber){
            return number;
        }else {
            return -1;
        }

    }
    public int selectBrand() throws SQLException {
        System.out.println("select a brand number: ");
        BaseEntity[]brands =brandService.findAll();
        for (BaseEntity brand:brands){
            System.out.println(brand.getId()+" >> "+brand.getName());
        }
        int number = input.nextInt();
        input.nextLine();
        //check if its valid
        boolean validBrandNumber=false;
        for(BaseEntity brand:brands){
            if(brand.getId()==number) {
                validBrandNumber=true;
                break;
            }
        }
        if(validBrandNumber){
            return number;
        }else {
            return -1;
        }
    }



    public void signIn() throws SQLException {
        System.out.println("Enter your username:");
        String username = input.nextLine();

        System.out.println("Enter your password:");
        String password = input.nextLine();

        User user = userService.login(username);
        if (user == null && !user.getPassword().equals(password)) {
            System.out.println("you enter a username and password incorrect");
            publicMenu();
        }else {
            System.out.println("you successfully logged in ");
            userOperation();
        }

    }

    public void userOperation() throws SQLException {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("=====================================");
            //System.out.println("1-update firstname");
            //System.out.println("2-delete account");
            System.out.println("3-add one brand");
            System.out.println("4-add one category");
            System.out.println("5-add one product");
            System.out.println("6-exit");
            int number = input.nextInt();
            input.nextLine();
            switch (number) {
                //case 1 -> userService.update(user);
               // case 2 -> userService.deleteById(user.getId());
                case 3 -> registerBrand();
                case 4 -> registerCategory();
                case 5 -> addProduct();
                case 6 -> isTrue = false;
                default -> System.out.println("it does not work!");
            }
        }
    }

}
