package com.example.atelier3.product;
import com.example.atelier3.product.model.Product;
import com.example.atelier3.product.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller //MVC
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProductsPage(
            Model model,
            @RequestParam(name="size", defaultValue = "5") int size,
            @RequestParam(name="page", defaultValue = "0") int page){
        try {
            List<Product> products = productService.getProducts();
            model.addAttribute("products", products);
            model.addAttribute("current_page",page);
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }

        return "products";
    }
}
