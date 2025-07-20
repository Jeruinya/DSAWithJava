package com.java.features.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Given a list of Product objects, count the number of products in each category.
record Product(String item, String category, double price) {

}

public class FindProductByCategories {
    public static void main(String args[]) {
        List<Product> p = Arrays.asList(
                new Product("Laptop", "Electoronics",100),
                new Product("Phone", "Electoronics",200),
                new Product("Shirt", "Clothing",300),
                new Product("Jacket", "Clothing",400));

        Map<String, Long> productCountByCategory = p.stream().
                collect(Collectors.groupingBy(Product::category, Collectors.counting()));
        System.out.println(productCountByCategory);

    }
}
