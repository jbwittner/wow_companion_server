package fr.wowcompanion.server.model;

import javax.persistence.*;

import fr.jbwittner.blizzardswagger.wowretailapi.model.NameObjectData;
import fr.wowcompanion.server.model.embeddable.LocalizedModel;
import lombok.Data;

@Entity
@Table(
    name = "REALM_CATEGORY",
    uniqueConstraints = { @UniqueConstraint(name = "UK_SLUG", columnNames = "SLUG") }
    )
@Data
public class RealmCategory {

    @Id
    @Column(name = "ID", nullable = false, updatable = false, insertable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer id;

    @Column(name = "SLUG", nullable = false)
    private String slug;

    @Embedded
    private LocalizedModel localizedModel;

    public void buildLocalizedModel(final NameObjectData nameObjectData){
        this.localizedModel = new LocalizedModel();
        this.localizedModel.updateLocalizedValue(nameObjectData);
    }
    
}
