package com.expressian.expressian.repositories;

import com.expressian.expressian.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository <Vehicle, Long >{
    @Modifying
    @Transactional
    @Query("DELETE FROM Vehicle v WHERE v.model = :model" )
    void deleteByModel(@Param("model") String model);

    @Query("SELECT v FROM Vehicle v WHERE v.brand = :brand")
    List<Vehicle> getAllByBrand(@Param("brand") String brand);
}
