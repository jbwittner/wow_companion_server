package fr.wowcompanion.server.model;

import lombok.Data;

import javax.persistence.*;

import java.time.Instant;

/**
 * Class of the User account
 */
@Data
@Entity
@Table(
    name = "USER_ACCOUNT",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_BATTLE_TAG", columnNames = "BATTLE_TAG"),
        @UniqueConstraint(name = "UK_EMAIL", columnNames = "EMAIL"),
        @UniqueConstraint(name = "UK_USER_NAME", columnNames = "USER_NAME")
})
public class UserAccount {

    @Id
    @Column(name = "BLIZZARD_ID", nullable = false, unique = true)
    private Integer blizzardId;

    @Column(name = "BATTLE_TAG", nullable = false, length = 60)
    private String battleTag;

    @Column(name = "USER_NAME", nullable = false, length = 60)
    private String userName;

    @Column(name = "EMAIL", nullable = false, length = 60)
    private String email;

    @Column(name = "CREATION_INSTANT", nullable = false)
    private Instant creationInstant;

    @Column(name = "LAST_LOGIN_INSTANT", nullable = false)
    private Instant lastLoginInstant;

    @Column(name = "IS_ADMIN", nullable = false)
    private boolean isAdmin = false;

}