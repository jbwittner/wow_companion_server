package fr.wowcompanion.server.dto;

import fr.wowcompanion.openapi.model.UserDTO;
import fr.wowcompanion.server.model.UserAccount;

public class UserDTOBuilder implements Transformer<UserAccount, UserDTO> {

    @Override
    public UserDTO transform(final UserAccount input) {
        final UserDTO userDTO = new UserDTO();
        userDTO.setBattletag(input.getBattleTag());
        userDTO.setBlizzardId(input.getBlizzardId());
        userDTO.setEmail(input.getEmail());
        userDTO.setUserName(input.getUserName());
        userDTO.setIsAdmin(input.isAdmin());
        return userDTO;
    }

}
