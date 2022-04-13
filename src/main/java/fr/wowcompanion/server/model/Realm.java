package fr.wowcompanion.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import fr.wowcompanion.server.model.mother.MotherLocalizedBlizzardModel;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(
    name = "REALMS",
    uniqueConstraints = { @UniqueConstraint(name = "UK_SLUG", columnNames = "SLUG") }
    )
public class Realm extends MotherLocalizedBlizzardModel{

    @Column(name = "SLUG", nullable = false)
    private String slug;

    @Column(name = "TIMEZONE",  nullable = false)
    private String timezone;

    @Column(name = "LOCALE",  nullable = false)
    private String locale;

    @ManyToOne
    @JoinColumn(name = "REALM_TYPE_ID",
        foreignKey = @ForeignKey(name = ("FK_REALM_TYPE_ID"))
    )
    private RealmType realmType;

    @ManyToOne
    @JoinColumn(name = "REALM_CATEGORY_ID",
        foreignKey = @ForeignKey(name = ("FK_REALM_CATEGORY_ID"))
    )
    private RealmCategory realmCategory;

}