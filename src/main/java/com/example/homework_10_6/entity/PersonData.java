package com.example.homework_10_6.entity;

import javax.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonData implements Serializable {

    private String name;
    private String surname;
    private int age;
}
