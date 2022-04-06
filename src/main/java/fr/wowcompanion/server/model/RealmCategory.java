package fr.wowcompanion.server.model;

import javax.persistence.*;

import fr.jbwittner.blizzardswagger.wowretailapi.model.NameData;
import fr.wowcompanion.server.model.embeddable.LocalizedModel;
import lombok.Data;

@Entity
@Table(name = "REALM_CATEGORY")
@Data
public class RealmCategory {

    @Id
    @Column(name = "ID", nullable = false, updatable = false, insertable = false, unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Integer id;

    @Column(name = "SLUG", nullable = false, unique = true)
    private String slug;

    @Embedded
    private LocalizedModel localizedModel;

    public void buildLocalizedModel(final NameData nameData){
        this.localizedModel = new LocalizedModel();
        this.localizedModel.updateLocalizedValue(nameData);
    }
    
}
