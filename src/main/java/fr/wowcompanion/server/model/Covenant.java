package fr.wowcompanion.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.wowcompanion.server.model.mother.MotherLocalizedBlizzardModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "COVENANT")
public class Covenant extends MotherLocalizedBlizzardModel{

    @Column(name = "MEDIA_URL")
    private String mediaURL;

}
