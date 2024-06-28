package fr.simplon.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.api.Exception.ResourceNotFoundException;
import fr.simplon.api.models.Product;
import fr.simplon.api.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private  ProductRepository productRepository;


    @GetMapping
    public List<Product> getAllProducts(){
    return productRepository.findAll();
}

    @PostMapping("/products")
    public Product createProduct(@ModelAttribute("name") String name, @ModelAttribute("price") Float price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return productRepository.save(product);
    }


    @GetMapping("/{productId}")
    public Optional<Product> getProductById(@PathVariable("productId") Integer productId){
    return productRepository.findById(productId);
}

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") Integer productid, @RequestBody Product updatedProduct) {
        Product product = productRepository.findById(productid).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        return productRepository.save(product);
    }


}
