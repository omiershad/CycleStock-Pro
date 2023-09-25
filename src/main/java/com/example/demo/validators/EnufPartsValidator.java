package com.example.demo.validators;

// import necessary classes
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */

// define custom constraint validator for ValidEnufParts
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {

    // Autowire Spring ApplicationContext to access
    @Autowired
    private ApplicationContext context;

    // static reference to ApplicationContext
    public static  ApplicationContext myContext;

    // Initialize method for the custom constraint annotation
    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    // isValid method performs validation logic
    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {

        // check if ApplicationContext is null
        if(context==null)
            return true;

        // if not null, assign to static myContext
        if(context!=null)myContext=context;
        ProductService repo = myContext.getBean(ProductServiceImpl.class);

        // check if product has ID other than 0
        if (product.getId() != 0) {

            // Retrieve existing product form repository using its ID
            Product myProduct = repo.findById((int) product.getId());

            // iterate over parts of existing product
            for (Part p : myProduct.getParts()) {

                // check if inventory of part is less than difference between new product's inventory
                if (p.getInv()<(product.getInv()-myProduct.getInv()))
                    return false;
            }
            return true;
        }
        else{
            return true;
        }
    }

}
