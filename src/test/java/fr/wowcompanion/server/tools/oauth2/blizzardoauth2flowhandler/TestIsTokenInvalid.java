package fr.wowcompanion.server.tools.oauth2.blizzardoauth2flowhandler;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import fr.wowcompanion.server.testhelper.AbstractMotherIntegrationTest;
import fr.wowcompanion.server.tools.oauth2.BlizzardOAuth2FlowHandler;

/**
 * Test class to test isTokenInvalid method
 */
class TestIsTokenInvalid extends AbstractMotherIntegrationTest {

    @Autowired
    private BlizzardOAuth2FlowHandler blizzardOAuth2FlowHandler;

    @Override
    public void initDataBeforeEach(){}
    
    /**
     * Test to check if the token is valid because it has not expired 
     */
    @Test
    void testIsTokenInvalidWithValidTokenOk() throws NoSuchFieldException {

        ReflectionTestUtils.setField(blizzardOAuth2FlowHandler, "tokenExpiry", 
            Instant.now().plus(1, ChronoUnit.MINUTES));

        ReflectionTestUtils.setField(blizzardOAuth2FlowHandler, "token", "SomeSampleToken");

        Assertions.assertFalse(blizzardOAuth2FlowHandler.isTokenInvalid());
    }

    /**
     * Test to check if the token is valid because it has not expired 
     */
    @Test
    void testIsTokenInvalidWithInValidTokenOk() throws NoSuchFieldException {

        ReflectionTestUtils.setField(blizzardOAuth2FlowHandler, "tokenExpiry", 
            Instant.now().minus(1, ChronoUnit.MINUTES));

        ReflectionTestUtils.setField(blizzardOAuth2FlowHandler, "token", "SomeSampleToken");

        Assertions.assertTrue(blizzardOAuth2FlowHandler.isTokenInvalid());
    }

    /**
     * Test to check if the token is not valid
     */
    @Test
    void testIsTokenInvalidWithNullTokenOk() throws NoSuchFieldException {

        ReflectionTestUtils.setField(blizzardOAuth2FlowHandler, "tokenExpiry", null);
        ReflectionTestUtils.setField(blizzardOAuth2FlowHandler, "token", null);

        Assertions.assertTrue(blizzardOAuth2FlowHandler.isTokenInvalid());
    }

    /**
     * Test to check if the token is valid
     */
    @Test
    void testIsTokenInvalidExpiredTokenExpiryOk() throws NoSuchFieldException {

        ReflectionTestUtils.setField(blizzardOAuth2FlowHandler, "tokenExpiry", Instant.EPOCH);
        ReflectionTestUtils.setField(blizzardOAuth2FlowHandler, "token", "SomeSampleToken");

        Assertions.assertTrue(blizzardOAuth2FlowHandler.isTokenInvalid());
    }

    /**
     * Test to check if the token is valid
     */
    @Test
    void testIsTokenInvalidNullTokenExpiryOk() throws NoSuchFieldException {

        ReflectionTestUtils.setField(blizzardOAuth2FlowHandler, "tokenExpiry", null);
        ReflectionTestUtils.setField(blizzardOAuth2FlowHandler, "token", "SomeSampleToken");

        Assertions.assertTrue(blizzardOAuth2FlowHandler.isTokenInvalid());
    }

}
