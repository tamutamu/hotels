package com.mnazarenka.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Table(name = "appartments")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "appartments_type")
public class Appartment extends BaseEntity implements Serializable {
    @Getter
    @Setter
    @Column(name = "appartments_type", insertable = false, updatable = false)
    private String appartmentsType;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fk_hotel_id")
    private Hotel hotel;
    @Getter
    @Setter
    @Column
    private String name;
    @Getter
    @Setter
    @Column(name = "guests_counts")
    private Integer guestsCounts;
    @Getter
    @Setter
    @Column(name = "cost_per_day")
    private Integer costPerDay;
    @Getter
    @Setter
    private String image;
    @Getter
    @Setter
    @Column(name = "wi_fi")
    private Boolean wiFi;
}
