package com.cbcode.cardatabase.repository;

import com.cbcode.cardatabase.domain.Sales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="sales")
public interface SalesRepository extends CrudRepository<Sales, Long> {
}
