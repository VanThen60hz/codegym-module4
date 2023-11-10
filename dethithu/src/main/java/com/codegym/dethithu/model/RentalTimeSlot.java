package com.codegym.dethithu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RentalTimeSlot {
    SLOT_17H30_18H30("17:30 - 18:30", 350000),
    SLOT_18H30_19H30("18:30 - 19:30", 400000),
    SLOT_19H30_20H30("19:30 - 20:30", 300000);

    private final String timeRange;
    private final int price;
}
