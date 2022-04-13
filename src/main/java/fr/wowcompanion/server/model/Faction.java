package fr.wowcompanion.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import fr.jbwittner.blizzardswagger.wowretailapi.model.NameObjectData;
import fr.wowcompanion.server.model.embeddable.LocalizedModel;

@EqualsAndHashCode()
@Data
@Entity
@Table(
    name = "FACTIONS",
    uniqueConstraints = { @UniqueConstraint(name = "UK_TYPE", columnNames = "TYPE") }
    )
public class Faction {

    @Id
    @Column(name = "ID", nullable = false, updatable = false, insertable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer id;

    @Column(name = "TYPE",  nullable = false)
    private String type;

    @Embedded
    private LocalizedModel localizedModel;

    public void buildLocalizedModel(final NameObjectData nameObjectData){
        this.localizedModel = new LocalizedModel();
        this.localizedModel.updateLocalizedValue(nameObjectData);
    }

}