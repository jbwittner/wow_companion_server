package fr.wowcompanion.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import fr.wowcompanion.server.model.mother.MotherLocalizedBlizzardModel;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PLAYABLE_RACES")
@Data
public class PlayableRace extends MotherLocalizedBlizzardModel{

    @ManyToOne
    @JoinColumn(name = "FACTION_ID")
    private Faction faction;

}
