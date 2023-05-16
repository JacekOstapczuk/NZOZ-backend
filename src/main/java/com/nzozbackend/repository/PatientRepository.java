package com.nzozbackend.repository;

import com.nzozbackend.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Override
    List<Patient> findAll();


    Optional<Patient> findById(Long id);

    @Override
    Patient save(Patient patient);

    @Override
    void deleteById(Long id);

}

