package com.example.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="SuperPower")
public class SuperPower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    private String effect;
    private int range;
    @Min(value = 1)
    @Max(value = 10)
    private int damage;

    @ManyToMany
    @JoinTable(
            name = "hero_superpower",
            joinColumns = @JoinColumn(name = "id_superpower", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_hero", referencedColumnName = "id")
    )
    private Set<Hero> heroes;

}