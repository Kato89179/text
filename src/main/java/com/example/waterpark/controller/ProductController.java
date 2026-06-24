package com.example.waterpark.controller;

import com.example.waterpark.model.Product;
import com.example.waterpark.model.ProductVariant;
import com.example.waterpark.model.ProductImage;
import com.example.waterpark.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    // ホームページ（商品一覧）
    @GetMapping(\"/\")
    public String index(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute(\"products\", products);
        return \"index\";
    }
    
    // 商品詳細ページ（動的ID対応）
    @GetMapping(\"/product/{id}\")
    public String detail(@PathVariable Integer id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        
        if (!product.isPresent()) {
            return \"error\";
        }
        
        List<ProductVariant> variants = productService.getVariantsByProductId(id);
        List<ProductImage> images = productService.getImagesByProductId(id);
        
        model.addAttribute(\"product\", product.get());
        model.addAttribute(\"variants\", variants);
        model.addAttribute(\"images\", images);
        return \"detail\";
    }
    
    // 購入ページ（動的ID対応）
    @GetMapping(\"/product/{id}/purchase\")
    public String purchase(@PathVariable Integer id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        
        if (!product.isPresent()) {
            return \"error\";
        }
        
        List<ProductVariant> variants = productService.getVariantsByProductId(id);
        List<ProductImage> images = productService.getImagesByProductId(id);
        
        model.addAttribute(\"product\", product.get());
        model.addAttribute(\"variants\", variants);
        model.addAttribute(\"images\", images);
        return \"purchase\";
    }
}
