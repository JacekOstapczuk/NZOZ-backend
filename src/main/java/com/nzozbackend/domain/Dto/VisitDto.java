package com.nzozbackend.domain.Dto;

import com.nzozbackend.domain.Outpost;
import com.nzozbackend.domain.Patient;
import com.nzozbackend.domain.Paymaster;
import com.nzozbackend.domain.Physician;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitDto {

    private Long id;
    private Physician physician;
    private Patient patient;
    private Paymaster paymaster;
    private Outpost outpost;
    private LocalDate date;
    private String visitName;
    private LocalTime visitDuration;
    private BigDecimal price;
    private String description;

    @NotNull
    public VisitDto(LocalDate date) {
        this.date = date;
    }
}
