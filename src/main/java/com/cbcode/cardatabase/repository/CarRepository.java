package com.cbcode.cardatabase.repository;

import com.cbcode.cardatabase.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    @Query("select c from Car c where c.model like %?1")
    List<Car> findByModelEndsWith(String model);

    List<Car> findByModel(@Param("model") String model);

    List<Car> findByRegisterNumber(@Param("registerNumber") String registerNumber);

    List<Car> findByChassisNumber(@Param("chassisNumber") String chassisNumber);
}
