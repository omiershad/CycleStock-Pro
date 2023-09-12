package com.example.demo.controllers;


import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BuyNowController {
    private final ProductRepository productRepository;
    private ApplicationContext context;
    @Autowired
    public BuyNowController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") Long productId) {

        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {

            if (optionalProduct.get().getInv() > 0) {
                System.out.println(optionalProduct.get().getInv());
                optionalProduct.get().setInv(optionalProduct.get().getInv() - 1);

                productRepository.save(optionalProduct.get());

                return "redirect:/purchaseSuccess";
            } else {
                return "redirect:/purchaseError";
            }
        } else {
            return "redirect:/purchaseError";
        }
    }


    @RequestMapping("/purchaseSuccess")
    public String displayPurchaseSuccess() {
        return "purchaseSuccess";
    }

    @RequestMapping("/purchaseError")
    public String displayPurchaseError() {
        return "purchaseError";
    }

}
