package com.WEATHER.pojo;

import jakarta.persistence.*;
import lombok.*;

 @Setter
@Getter
@ToString
@Table
@Entity
public class Tourist
{
    public Tourist()
    {
        System.out.println ("*Entity called*");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer tid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PACKAGE")
    private String packageType;

    @Column(name = "BUDGET")
    private Double budget;
}
