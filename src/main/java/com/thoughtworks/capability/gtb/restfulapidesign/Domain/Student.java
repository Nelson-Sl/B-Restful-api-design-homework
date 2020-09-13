package com.thoughtworks.capability.gtb.restfulapidesign.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private Gender gender;
    private String note;
}
