package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.*;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitDto {

    private Long id;
    private Physician physician;
    private Patient patient;
    private Paymaster paymaster;
    private Outpost outpost;
    private Date date;
    private String visitName;
    private LocalTime visitDuration;
    private BigDecimal price;
    private String description;

    @NotNull
    public VisitDto(Date date) {
        this.date = date;
    }
}
