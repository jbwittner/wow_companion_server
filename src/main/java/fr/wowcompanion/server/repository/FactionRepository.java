package fr.wowcompanion.server.repository;

import java.util.Optional;

import fr.wowcompanion.server.model.Faction;

public interface FactionRepository extends AbstractRepository<Faction, Integer> {

    Optional<Faction> findByType(String type);

}
