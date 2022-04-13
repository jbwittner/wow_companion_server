package fr.wowcompanion.server.testhelper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.wowcompanion.server.model.UserAccount;
import fr.wowcompanion.server.repository.UserAccountRepository;


@Component
public class TestFactory {

    @Autowired
    private UserAccountRepository userAccountRepository;

    private final Faker faker = new Faker();

    public static final Integer NUMBER_MAX = 20_000_000;

    public static final int LENGTH_STANDARD = 30;

    private List<String> listRandomString = new ArrayList<>();
    private List<String> listRandomCaseSensitiveString = new ArrayList<>();
    private List<String> listRandomEmail = new ArrayList<>();
    private List<String> listRandomName = new ArrayList<>();
    private List<Integer> listInteger = new ArrayList<>();

    public void resetAllList(){

        this.listRandomString = new ArrayList<>();
        this.listRandomCaseSensitiveString = new ArrayList<>();
        this.listRandomEmail = new ArrayList<>();
        this.listRandomName = new ArrayList<>();
        this.listInteger = new ArrayList<>();
    }

    public String getUniqueRandomAlphanumericString(final int length){

        boolean isNotUnique = true;
        String randomString = "";

        while (isNotUnique){
            randomString = RandomStringUtils.randomAlphanumeric(length);
            isNotUnique = listRandomString.contains(randomString);
        }

        listRandomString.add(randomString);

        return randomString;
    }

    public String getUniqueRandomAlphanumericStringCaseSensitive(final int length){
        boolean isNotUnique = true;
        String randomString = "";

        while (isNotUnique){
            randomString = RandomStringUtils.randomAlphanumeric(length).toLowerCase();
            isNotUnique = listRandomCaseSensitiveString.contains(randomString);
        }

        listRandomCaseSensitiveString.add(randomString);

        return randomString;
    }


    public String getUniqueRandomAlphanumericString(){

        boolean isNotUnique = true;
        String randomString = "";

        while (isNotUnique){
            randomString = this.getRandomAlphanumericString();
            isNotUnique = listRandomString.contains(randomString);
        }

        listRandomString.add(randomString);

        return randomString;
    }

    public String getRandomAlphanumericString(final int length){

        return RandomStringUtils.randomAlphanumeric(length);
    }

    public String getRandomAlphanumericString(){

        return RandomStringUtils.randomAlphanumeric(LENGTH_STANDARD);
    }

    public Name getUniqueRandomName(){

        boolean isNotUnique = true;
        Name randomName = this.faker.name();

        while (isNotUnique){
            randomName = this.faker.name();
            isNotUnique = listRandomName.contains(randomName.username());
        }

        listRandomName.add(randomName.username());

        return randomName;
    }

    public String getUniqueRandomEmail(){
        boolean isNotUnique = true;
        String email = "";

        while (isNotUnique){
            email = this.faker.internet().emailAddress();
            isNotUnique = listRandomEmail.contains(email);
        }

        listRandomEmail.add(email);

        return email;

    }

    public int getRandomInteger(final Integer max){
        final double random = Math.random() * max;
        return (int) random;
    }

    public int getUniqueRandomInteger(){
        boolean isNotUnique = true;
        double random = 0;

        while (isNotUnique){
            random = this.getRandomInteger();
            isNotUnique = listInteger.contains((int) random);
        }

        return (int) random;
    }


    public double getRandomDouble(){
        return this.faker.random().nextDouble();
    }

    public int getRandomInteger(){
        return this.getRandomInteger(NUMBER_MAX);
    }

    public UserAccount getUserAccount(){
        final UserAccount userAccount = new UserAccount();
        userAccount.setBattleTag(this.getUniqueRandomAlphanumericString());
        userAccount.setBlizzardId(this.getUniqueRandomInteger());
        userAccount.setEmail(this.getUniqueRandomEmail());
        userAccount.setUserName(this.getUniqueRandomAlphanumericString());
        userAccount.setCreationInstant(Instant.EPOCH);
        userAccount.setLastLoginInstant(Instant.EPOCH);
        return this.userAccountRepository.save(userAccount);
    }

}
