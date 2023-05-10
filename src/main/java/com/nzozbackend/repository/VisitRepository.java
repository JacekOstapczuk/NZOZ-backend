package com.nzozbackend.repository;

import com.nzozbackend.domain.Physician;
import com.nzozbackend.domain.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

    @Override
    List<Visit> findAll();

    Optional<Visit> findById(Long id);
    @Override
    Visit save(Visit visit);

    @Override
    void deleteById(Long id);

}
