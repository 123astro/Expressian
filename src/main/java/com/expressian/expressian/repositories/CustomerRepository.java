package com.expressian.expressian.repositories;

import com.expressian.expressian.models.Customers;
import com.expressian.expressian.models.Vehicle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

    @Query("SELECT c FROM Customers c WHERE c.firstName = :firstName")
    List<Customers> getAllByFirstName(@Param("firstName") String firstName);

    List<Customers> findAllByLastName(String lastName, Sort sort);
}
