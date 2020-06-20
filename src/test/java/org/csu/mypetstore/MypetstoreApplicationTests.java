package org.csu.mypetstore;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatalogService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("org.csu.mypetstore.persistence")
class MypetstoreApplicationTests {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private AccountService accountService;

    @Test
    void contextLoads() {
    }

    @Test
    void testCategoryMapper() {
        Category category = catalogService.getCategory("CATS");
        printInfo(category);
        System.out.println("--------------------------------------------------");
        List<Category> categoryList = catalogService.getCategoryList();
        for (Category temp : categoryList) {
            printInfo(temp);
        }
    }

    private void printInfo(Category category) {
        System.out.println(category.getCategoryId() + "," + category.getName() + "," + category.getDescription());
    }

    @Test
    void testProductMapper() {
        Product product = catalogService.getProduct("FI-SW-02");
        printInfo(product);
        System.out.println("--------------------------------------------------");
        List<Product> productList = catalogService.getProductListByCategory("DOGS");
        for (Product temp : productList) {
            printInfo(temp);
        }
        System.out.println("--------------------------------------------------");
        List<Product> searchProductList = catalogService.searchProductList("dog");
        for (Product temp : searchProductList) {
            printInfo(temp);
        }
        System.out.println("--------------------------------------------------");
    }

    private void printInfo(Product product) {
        System.out.println(product.getCategoryId() + "," + product.getProductId() + "," + product.getName() + "," + product.getDescription());
    }

    @Test
    void testItemMapper() {
        Item item = catalogService.getItem("EST-18");
        printInfo(item);
        System.out.println("--------------------------------------------------");
        printInfo(item.getProduct());
        System.out.println("--------------------------------------------------");

        List<Item> itemList = catalogService.getItemListByProduct("K9-RT-02");
        for (Item temp : itemList) {
            printInfo(temp);
        }
        System.out.println("--------------------------------------------------");

        boolean isItemInStock = catalogService.isItemInStock("EST-26");
        System.out.println(isItemInStock);
        System.out.println("--------------------------------------------------");
    }

    private void printInfo(Item item) {
        System.out.println(item.getProductId() + "," + item.getItemId() + "," + item.getListPrice() + "," +
                item.getUnitCost() + "," + item.getSupplierId() + "," + item.getStatus() + "," + item.getQuantity());
    }

    @Test
    void testAccountMapper() {
        Account account =accountService.getAccount("j2ee");
        printInfo(account);

        account = accountService.getAccount("j2ee","j2ee");
        printInfo(account);

        Account temp = account;
        temp.setUsername("xyz");
        temp.setPassword("zyx");
        accountService.insertAccount(temp);

        temp.setPassword("xyz");
        temp.setEmail("xyz@csu.edu.cn");
        accountService.updateAccount(temp);
    }

    private void printInfo(Account account) {
        System.out.println(account.getUsername() + "," + account.getEmail() + "," + account.getFirstName() + "," +
                account.getLastName()+","+account.getStatus()+","+account.getAddress1()+","+account.getAddress2()+","+
                account.getCity()+","+account.getState()+","+account.getZip()+","+account.getCountry()+","+account.getPhone());
        System.out.println("--------------------------------------------------");
        System.out.println(account.getUsername()+","+account.getLanguagePreference()+","+account.getFavouriteCategoryId()+
                ","+account.isListOption()+","+account.isBannerOption()+","+account.getBannerName());
        System.out.println("--------------------------------------------------");
        System.out.println(account.getUsername()+","+account.getPassword());
    }
}
