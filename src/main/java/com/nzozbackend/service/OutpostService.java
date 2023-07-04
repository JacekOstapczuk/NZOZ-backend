package com.nzozbackend.service;

import com.nzozbackend.domain.Dto.OutpostDto;
import com.nzozbackend.domain.Outpost;
import com.nzozbackend.mapper.OutpostMapper;
import com.nzozbackend.repository.OutpostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutpostService {
    public final OutpostRepository outpostRepository;
    public final OutpostMapper outpostMapper;

    public List<OutpostDto> findAllOutpostDto() {
        return outpostMapper.mapToOutpostDtoList(outpostRepository.findAll());
    }

    public Outpost findOutpost(Long outpostId) {
        return outpostRepository.findById(outpostId).get();
    }

    public Outpost saveOutpostDto(OutpostDto outpostDto) {
        return outpostRepository.save(outpostMapper.mapToOutpost(outpostDto));
    }

    public void deleteOutpostById(final Long outpostId) {
        outpostRepository.deleteById(outpostId);
    }
}
