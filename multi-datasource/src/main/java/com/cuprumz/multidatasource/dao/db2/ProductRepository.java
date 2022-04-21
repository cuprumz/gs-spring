package com.cuprumz.multidatasource.dao.db2;

import com.cuprumz.multidatasource.model.db2.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
  extends JpaRepository<Product, Integer> { }