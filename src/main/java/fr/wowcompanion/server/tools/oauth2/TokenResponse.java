package fr.wowcompanion.server.tools.oauth2;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class TokenResponse {

    public static final String SERIALIZED_NAME_ACCESS_TOKEN = "access_token";
    @SerializedName(SERIALIZED_NAME_ACCESS_TOKEN)
    private String accessToken;

    public static final String SERIALIZED_NAME_TOKEN_TYPE = "token_type";
    @SerializedName(SERIALIZED_NAME_TOKEN_TYPE)
    private String tokenType;

    public static final String SERIALIZED_NAME_EXPIRES_IN = "expires_in";
    @SerializedName(SERIALIZED_NAME_EXPIRES_IN)
    private Long expiresIn;
}
