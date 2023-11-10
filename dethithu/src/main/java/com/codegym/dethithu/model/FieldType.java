package com.codegym.dethithu.model;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
public enum FieldType {
    SAN_5_NGUOI("Sân 5 người"),
    SAN_7_NGUOI("Sân 7 người"),
    SAN_11_NGUOI("Sân 11 người");

    private final String displayName;
}

