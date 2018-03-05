package com.kairos.examen

import org.springframework.data.repository.CrudRepository
import com.kairos.examen.Product

public interface ProductRepository extends CrudRepository<Product, Long> {

}

