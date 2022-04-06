package fr.wowcompanion.server.model;

import lombok.Data;

import javax.persistence.*;

import fr.jbwittner.blizzardswagger.wowretailapi.model.NameData;
import fr.wowcompanion.server.model.embeddable.LocalizedModel;

@Entity
@Table(name = "SPECIALIZATION_ROLES")
@Data
public class SpecializationRole {

    @Id
    @Column(name = "ID", nullable = false, updatable = false, insertable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer id;

    @Column(name = "TYPE",  nullable = false, unique = true)
    private String type;

    @Embedded
    private LocalizedModel localizedModel;

    public void buildLocalizedModel(final NameData nameData){
        this.localizedModel = new LocalizedModel();
        this.localizedModel.updateLocalizedValue(nameData);
    }

}
