package fr.wowcompanion.server.model.mother;

import javax.persistence.*;

import lombok.Data;

@Data
@MappedSuperclass
public class MotherModel {

    @Id
    @Column(name = "id", nullable = false, updatable = false, insertable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

}