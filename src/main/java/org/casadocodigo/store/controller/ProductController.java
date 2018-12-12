package org.casadocodigo.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/products/form")
    public String getProductForm() {
        return "products/form";
    }

    @RequestMapping("/products")
    public String addProduct(String title, String description, int pages) {
        System.out.println(title);
        System.out.println(description);
        System.out.println(pages);

        return "products/success";
    }
}
