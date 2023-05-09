package com.nzozbackend.repository;

import com.nzozbackend.domain.Paymaster;
import com.nzozbackend.domain.Physician;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhysicianRepository extends CrudRepository<Physician, Long> {

    @Override
    List<Physician> findAll();

    @Override
    Physician save(Physician  physician);

    @Override
    void deleteById(Long id);

}