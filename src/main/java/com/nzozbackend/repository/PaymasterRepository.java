package com.nzozbackend.repository;

import com.nzozbackend.domain.Paymaster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface PaymasterRepository extends CrudRepository<Paymaster, Long> {

    @Override
    List<Paymaster> findAll();

    @Override
    Paymaster save(Paymaster paymaster);

    @Override
    void deleteById(Long id);

}

