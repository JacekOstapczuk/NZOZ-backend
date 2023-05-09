package com.nzozbackend.repository;

import com.nzozbackend.domain.Outpost;
import com.nzozbackend.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

        @Override
        List<Patient> findAll();

        @Override
        Patient save(Patient patient);

        @Override
        void deleteById(Long id);

        }

