package com.codegym.dethithu.dto;

import com.codegym.dethithu.model.Area;
import com.codegym.dethithu.model.FieldType;
import com.codegym.dethithu.model.RentalTimeSlot;
import com.codegym.dethithu.service.IStadiumService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.hibernate.Internal;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.io.Serializable;

/**
 * DTO for {@link com.codegym.dethithu.model.Stadium}
 */
@Value
public class StadiumDTO implements Serializable, Validator {
    Integer id;
    @NotNull(message = "Not null bro")
    @Size(message = "Size not valid", min = 3, max = 22)
    String name;
    @NotNull
    String address;
    Area area;
    FieldType fieldType;
    RentalTimeSlot rentalTimeSlot;

    public void validateNameUnique(IStadiumService stadiumService, Errors errors) {
        if (!stadiumService.isStadiumNameUnique(name)) {
            errors.rejectValue("name", "error.stadiumDto", "Tên sân đã tồn tại.");
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}