package fr.wowcompanion.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import fr.wowcompanion.server.model.mother.MotherLocalizedBlizzardModel;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PLAYABLE_SPECIALIZATIONS")
@Data
public class PlayableSpecialization extends MotherLocalizedBlizzardModel{

    @Column(name = "MEDIA_URL")
    private String mediaURL;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAYABLE_CLASS_ID",
        foreignKey = @ForeignKey(name = ("FK_PLAYABLE_CLASS_ID"))
    )
    private PlayableClass playableClass;

    @ManyToOne
    @JoinColumn(name = "SPECIALIZATION_ROLE_ID",
        foreignKey = @ForeignKey(name = ("FK_SPECIALIZATION_ROLE_ID"))
    )
    private SpecializationRole specializationRole;

}
