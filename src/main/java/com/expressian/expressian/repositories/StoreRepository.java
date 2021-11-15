package com.expressian.expressian.repositories;

import com.expressian.expressian.models.Store;
import com.expressian.expressian.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StoreRepository extends JpaRepository<Store, Long> {

}
