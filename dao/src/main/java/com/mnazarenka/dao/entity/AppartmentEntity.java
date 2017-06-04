package com.mnazarenka.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@ToString(callSuper = true)
@Entity
@Table(name = "appartments")
public class AppartmentEntity extends BaseDao implements Serializable {

    /*@Getter
    @Setter
    private int fkKategoryId;
    */
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "fk_hotel_id", nullable = false)
    private HotelEntity hotel;
    @Getter
    @Setter
    @Column
    private String name;
    @Getter
    @Setter
    @Column
    private String description;
}
