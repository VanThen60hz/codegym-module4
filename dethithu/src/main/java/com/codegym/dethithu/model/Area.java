package com.codegym.dethithu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum Area {
    SON_TRA("Sơn Trà"),
    HAI_CHAU("Hải Châu"),
    NGU_HANH_SON("Ngũ Hành Sơn"),
    LIEN_CHIEU("Liên Chiểu");

    private final String displayName;
    

}

