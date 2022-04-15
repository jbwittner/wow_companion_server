package fr.wowcompanion.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterData;
import fr.jbwittner.blizzardswagger.wowretailapi.model.CharacterIndexData;
import fr.wowcompanion.openapi.api.UserApi;
import fr.wowcompanion.openapi.model.UserDTO;
import fr.wowcompanion.openapi.model.UserRegistrationParameter;
import fr.wowcompanion.server.service.UserService;
import fr.wowcompanion.server.tools.api.blizzardapi.BlizzardAPIHelper;


@RestController
public class UserController implements UserApi {
    
    @Autowired
    private UserService userService;

    @Autowired
    private BlizzardAPIHelper blizzardAPIHelper;

    @Override
    public ResponseEntity<UserDTO> userRegistration(final UserRegistrationParameter userRegistrationParameter){
        final UserDTO userDTO = this.userService.registration(userRegistrationParameter);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> getUser() {
        final UserDTO userDTO = this.userService.getUser();
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/toto")
    public void toto() {
        final long startTime = System.currentTimeMillis();

        var tata = this.blizzardAPIHelper.getProfileAccountData();
        //System.out.println(tata);

        var characters = tata.getWowAccounts().get(0).getCharacters();

        for(CharacterIndexData characterIndexData : characters){
            var character = this.blizzardAPIHelper.getCharacter(characterIndexData.getRealm().getSlug(), characterIndexData.getName());
            //System.out.println(character);
        }

        final long endTime = System.currentTimeMillis() - startTime;

        System.out.println(endTime);
    }

    @GetMapping("/titi")
    public void titi() {
        final long startTime = System.currentTimeMillis();

        var tata = this.blizzardAPIHelper.getProfileAccountData();
        //System.out.println(tata);

        var characters = tata.getWowAccounts().get(0).getCharacters();

        final List<CompletableFuture<CharacterData>> completableFuturesCharacterData = new ArrayList<>();

        for(CharacterIndexData characterIndexData : characters){
            final CompletableFuture<CharacterData> completableFutureCharacterData =
                this.blizzardAPIHelper.getCharacterAsync(characterIndexData.getRealm().getSlug(), characterIndexData.getName().toLowerCase());
            completableFuturesCharacterData.add(completableFutureCharacterData);
        }

        completableFuturesCharacterData.forEach((completableFuture) -> {
            final CharacterData data = completableFuture.join();
        });

        final long endTime = System.currentTimeMillis() - startTime;

        System.out.println(endTime);
    }

}
