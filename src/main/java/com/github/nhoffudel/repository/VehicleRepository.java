package com.github.nhoffudel.repository;

import com.github.nhoffudel.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
