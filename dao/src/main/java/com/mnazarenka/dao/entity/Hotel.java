package com.mnazarenka.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "my-cache")
@Table(name = "hotels")
public class Hotel extends BaseEntity implements Serializable {
    @Getter
    @Setter
    @Column
    private String name;
    @Getter
    @Setter
    @OneToMany(mappedBy = "hotel")
    private Set<Appartment> entities;
    @Getter
    @Setter
    @Embedded
    private Adress adress;
    @Getter
    @Setter
    @OneToOne(mappedBy = "hotel")
    private Restaurant restaurant;

}
