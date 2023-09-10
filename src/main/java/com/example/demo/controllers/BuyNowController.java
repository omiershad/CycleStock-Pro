package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyNowController {
    private final ProductRepository productRepository;

    @Autowired
    public BuyNowController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


@PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            if (product.getInv() > 0) {

                product.setInv(product.getInv() - 1);

                productRepository.save(product);

                return "redirect:/purchaseSuccess";
            } else {
                return "redirect:/purchaseError";
            }
        } else {
            return "redirect:/purchaseError";
        }
}

@GetMapping("/purchaseSuccess")
    public String displayPurchaseSuccess() {
        return "purchaseSuccess";
}

@GetMapping(".purchaseError")
    public String displayPurchaseError() {
        return "purchaseError";
}






}
