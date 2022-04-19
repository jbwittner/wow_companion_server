package fr.wowcompanion.server.repository;

import fr.wowcompanion.server.model.Realm;

public interface RealmRepository extends AbstractRepository<Realm, Integer> {

    Realm getBySlug(String slug);

}
