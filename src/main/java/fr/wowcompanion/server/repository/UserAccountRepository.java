package fr.wowcompanion.server.repository;

import fr.wowcompanion.server.model.UserAccount;

public interface UserAccountRepository extends AbstractRepository<UserAccount, Long> {

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

    boolean existsByBattleTag(String battleTag);

    boolean existsByBlizzardId(Integer blizzardId);

}
