package fr.simplon.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.api.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Optional<Product> findByName(String name);

}
