package com.repositories;

import com.entites.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findAll();

    @Query(value = "SELECT * FROM store.product WHERE price = (SELECT max(price) FROM store.product)",
            nativeQuery = true)
    List<Product> MaxPriceQuery();

    @Query(value = "SELECT * FROM store.product WHERE price = (SELECT min(price) FROM store.product)",
            nativeQuery = true)
    List<Product> MinPriceQuery();

    @Query(value = "SELECT * FROM store.product WHERE price = (SELECT min(price) FROM store.product)\n" +
            "UNION\n" +
            "SELECT * FROM store.product WHERE price = (SELECT max(price) FROM store.product)", nativeQuery = true)
    List<Product> MaxAndMinPriceQuery();
}
