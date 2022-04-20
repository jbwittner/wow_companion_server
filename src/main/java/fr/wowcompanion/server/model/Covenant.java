package fr.wowcompanion.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import fr.wowcompanion.server.model.mother.MotherLocalizedBlizzardModel;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "COVENANT")
public class Covenant extends MotherLocalizedBlizzardModel{

    @Column(name = "MEDIA_URL")
    private String mediaURL;

}
