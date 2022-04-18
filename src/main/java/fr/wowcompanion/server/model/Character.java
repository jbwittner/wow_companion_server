package fr.wowcompanion.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import fr.wowcompanion.server.model.mother.MotherBlizzardModel;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CHARACTERS")
@Data
public class Character extends MotherBlizzardModel {

    @Column(name = "NAME")
    private String name;

    @Column(name = "LEVEL")
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "USER_ACCOUNT_ID")
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name = "GUILD_ID")
    private Guild guild;

    @ManyToOne
    @JoinColumn(name = "REALM_ID")
    private Realm realm;

    @ManyToOne
    @JoinColumn(name = "PLAYABLE_CLASS_ID")
    private PlayableClass playableClass;

    @ManyToOne
    @JoinColumn(name = "PLAYABLE_RACE_ID")
    private PlayableRace playableRace;

    @ManyToOne
    @JoinColumn(name = "MAIN_PLAYABLE_SPECIALIZATION_ID")
    private PlayableSpecialization mainPlayableSpecialization;

    @ManyToOne
    @JoinColumn(name = "COVENANT_ID")
    private Covenant covenant;

    @Column(name = "RENOWN_LEVEL")
    private Integer renownLevel;

    @ManyToOne
    @JoinColumn(name = "GUILD_RANK_ID")
    private GuildRank guildRank;

    @Column(name= "IS_FAVORITE")
    private boolean isFavorite = false;

    @Column(name = "AVERAGE_ITEM_LEVEL")
    private Integer averageItemLevel;

    @Column(name = "EQUIPPED_ITEM_LEVEL")
    private Integer equippedItemLevel;

    @Column(name = "LAST_LOGIN_TIMESTAMP")
    private Long lastLoginTimestamp;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @Column(name = "MEDIA_AVATAR_URL")
    private String mediaAvatarURL;

    @Column(name = "MEDIA_INSET_URL")
    private String mediaInsetURL;

    @Column(name = "MEDIA_MAIN_URL")
    private String mediaMainURL;

    public void setIsFavoritesTrue(){
        this.isFavorite = true;
    }

    public void setIsFavoritesFalse(){
        this.isFavorite = false;
    }

    public void setIsActiveTrue(){
        this.isActive = true;
    }

    public void setIsActiveFalse(){
        this.isActive = false;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", id=" + id +
                ", isActive=" + isActive +
                '}';
    }
}
