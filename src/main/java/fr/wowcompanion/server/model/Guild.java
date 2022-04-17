package fr.wowcompanion.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import fr.wowcompanion.server.model.mother.MotherBlizzardModel;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "GUILDS")
public class Guild extends MotherBlizzardModel {

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "guild", fetch = FetchType.LAZY)
    private List<Character> characterList;

    @ManyToOne
    @JoinColumn(name = "REALM_ID")
    private Realm realm;

    @ManyToOne
    @JoinColumn(name = "FACTION_ID")
    private Faction faction;

    @Column(name = "USE_APPLICATION")
    private Boolean useApplication = false;

}
