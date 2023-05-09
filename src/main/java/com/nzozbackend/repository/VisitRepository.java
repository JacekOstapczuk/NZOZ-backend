package com.nzozbackend.repository;

import com.nzozbackend.domain.Physician;
import com.nzozbackend.domain.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

    @Override
    List<Visit> findAll();

    @Override
    Visit save(Visit  visit);

    @Override
    void deleteById(Long id);

}
