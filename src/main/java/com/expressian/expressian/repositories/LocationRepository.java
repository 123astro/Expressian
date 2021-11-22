package com.expressian.expressian.repositories;


import com.expressian.expressian.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LocationRepository extends JpaRepository<Location, Long> {

}
