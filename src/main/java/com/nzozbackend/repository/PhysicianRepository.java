package com.nzozbackend.repository;

import com.nzozbackend.domain.Physician;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PhysicianRepository extends CrudRepository<Physician, Long> {

    @Override
    List<Physician> findAll();

    Optional<Physician> findById(Long id);

    @Override
    Physician save(Physician physician);

    @Override
    void deleteById(Long id);

}