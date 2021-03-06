package com.mnazarenka.dao.entity;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@DiscriminatorValue("econom")
public class EconomAppartment extends Appartment implements Serializable {
}
