package com.udemy.spring.entities.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> index() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> index(@PathVariable Long id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado");
        }
        return ResponseEntity.ok(product.get());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProductResponse> store(@RequestBody ProductRequest request) {
        Product product = productRepository.save(request.toModel());

        return ResponseEntity.ok(
                new ProductResponse(
                        product.getId().toString(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getImgUrl(),
                        product.getCategories()
                )
        );
    }
}
