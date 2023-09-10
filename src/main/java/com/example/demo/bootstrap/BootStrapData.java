// check sample code with CI. line 95-105, 125-129

package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        long partsCount = partRepository.count();
        long productsCount = productRepository.count();

        if (partsCount == 0 && productsCount == 0) {

        // Sample Parts
        OutsourcedPart o1 = new OutsourcedPart();
        o1.setCompanyName("Bakery Inc");
        o1.setName("Bun");
        o1.setInv(2);
        o1.setMin(0);
        o1.setMax(10);
        o1.setPrice(3);
        o1.setId(1L);
        outsourcedPartRepository.save(o1);
        OutsourcedPart thePart1=null;

        OutsourcedPart o2 = new OutsourcedPart();
        o2.setCompanyName("Meat Company");
        o2.setName("Patty");
        o2.setInv(2);
        o2.setMin(0);
        o2.setMax(10);
        o2.setPrice(3);
        o2.setId(2L);
        outsourcedPartRepository.save(o2);
        OutsourcedPart thePart2=null;

        OutsourcedPart o3 = new OutsourcedPart();
        o3.setCompanyName("Dairy Farmers");
        o3.setName("Cheese");
        o3.setInv(2);
        o3.setMin(0);
        o3.setMax(10);
        o3.setPrice(3);
        o3.setId(3L);
        outsourcedPartRepository.save(o3);
        OutsourcedPart thePart3=null;

        OutsourcedPart o4 = new OutsourcedPart();
        o4.setCompanyName("Produce Inc");
        o4.setName("Toppings");
        o4.setInv(2);
        o4.setMin(0);
        o4.setMax(10);
        o4.setPrice(3);
        o4.setId(4L);
        outsourcedPartRepository.save(o4);
        OutsourcedPart thePart4=null;

        OutsourcedPart o5 = new OutsourcedPart();
        o5.setCompanyName("Sauces & Spreads");
        o5.setName("Sauce");
        o5.setInv(2);
        o5.setMin(0);
        o5.setMax(10);
        o5.setPrice(3);
        o5.setId(5L);
        outsourcedPartRepository.save(o5);
        OutsourcedPart thePart5=null;

       /* List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        } */

        // Sample products
        Product cheeseburger = new Product("Cheeseburger", 5.00, 25);
        productRepository.save(cheeseburger);

        Product hamburger = new Product("Hamburger", 4.00, 20);
        productRepository.save(hamburger);

        Product chickenSandwich = new Product("Chicken Sandwich", 4.50, 15);
        productRepository.save(chickenSandwich);

        Product veggieBurger = new Product("Veggie Burger", 4.00, 10);
        productRepository.save(veggieBurger);

        Product fishSandwich = new Product("Fish Sandwich", 5.50, 5);
        productRepository.save(fishSandwich);
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
