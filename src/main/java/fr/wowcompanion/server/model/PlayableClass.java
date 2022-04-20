package fr.wowcompanion.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import fr.wowcompanion.server.model.mother.MotherLocalizedBlizzardModel;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PLAYABLE_CLASSES")
@Data
public class PlayableClass extends MotherLocalizedBlizzardModel{

    @Column(name = "MEDIA_URL")
    private String mediaURL;

    @OneToMany(mappedBy = "playableClass", cascade = CascadeType.ALL)
    private List<PlayableSpecialization> playableSpecializationList;

	@Override
	public String toString() {
		return "PlayableClass [playableSpecializationList=" + playableSpecializationList + "]";
	}

}
