package com.java.features.java8;

import java.util.*;
import java.util.stream.Collectors;

//Group products by category and find the most expensive product in each category.
public class GroupByCategoryAndFindExpensiveProduct {
    public static void main(String[] args) {

        List<Product> productList = Arrays.asList(
                new Product("Laptop", "Electronics", 1500),
                new Product("Phone", "Electronics", 800),
                new Product("Shirt", "Clothing", 50),
                new Product("Jacket", "Clothing", 120)
        );

        Map<String, Optional<Product>> mostExpensiveByCategory = productList.stream()
                .collect(Collectors.groupingBy(
                        Product::category,  // Group products by category
                        Collectors.maxBy(Comparator.comparing(Product::price))));

        mostExpensiveByCategory.forEach((category, product) ->
                System.out.println(category + ": " + product.get().item()));
    }
}
