package fr.wowcompanion.server.repository;

import java.util.Optional;

import fr.wowcompanion.server.model.Realm;

public interface RealmRepository extends AbstractRepository<Realm, Integer> {

    Optional<Realm> findBySlug(String slug);

}
