package fr.wowcompanion.server.repository;

import java.util.Optional;

import fr.wowcompanion.server.model.UserAccount;

public interface UserAccountRepository extends AbstractRepository<UserAccount, Long> {

    Optional<UserAccount> findByBlizzardId(Integer blizzardId);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

    boolean existsByBattleTag(String battleTag);

    boolean existsByBlizzardId(Integer blizzardId);

}
