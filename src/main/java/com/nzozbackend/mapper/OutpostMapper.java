package com.nzozbackend.mapper;

import com.nzozbackend.domain.Dto.OutpostDto;
import com.nzozbackend.domain.Outpost;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutpostMapper {

    public Outpost mapToOutpost (final OutpostDto outpostDto) {
        return new Outpost(
                outpostDto.getId(),
                outpostDto.getCity(),
                outpostDto.getAdministrator(),
                outpostDto.getVisits()
        );
    }

    public OutpostDto mapToOutpostDto (final Outpost outpost) {
        return new OutpostDto(
                outpost.getId(),
                outpost.getCity(),
                outpost.getAdministrator(),
                outpost.getVisits()
        );
    }

    public List<OutpostDto> mapToOutpostDtoList(final List<Outpost> outpostsList) {
        return  outpostsList.stream()
                .map(this::mapToOutpostDto)
                .collect(Collectors.toList());
    }
}
