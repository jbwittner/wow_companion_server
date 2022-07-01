package fr.wowcompanion.server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GUILD_RANKS")
@Data
public class GuildRank {

    @Id
    @Column(name = "ID", nullable = false, updatable = false, insertable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "GUILD_RANK")
    private Integer rank;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "guildRank", fetch = FetchType.LAZY)
    private List<Character> characterList;

}
