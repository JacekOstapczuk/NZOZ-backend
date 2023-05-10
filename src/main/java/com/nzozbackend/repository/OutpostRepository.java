package com.nzozbackend.repository;

import com.nzozbackend.domain.Outpost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface OutpostRepository extends CrudRepository<Outpost, Long> {

    @Override
    List<Outpost> findAll();

    Optional<Outpost> findById(Long id);

    @Override
    Outpost save(Outpost outpost);

    @Override
    void deleteById(Long id);


}
