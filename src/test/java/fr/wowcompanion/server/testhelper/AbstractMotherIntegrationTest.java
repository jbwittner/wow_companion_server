package fr.wowcompanion.server.testhelper;

import javax.transaction.Transactional;

import com.github.javafaker.Faker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public abstract class AbstractMotherIntegrationTest {

    protected final Faker faker = new Faker();

    protected final double epsilon = 0.000_01d;

    @Autowired
    protected TestFactory testFactory;

    /**
     * Method launch before each test
     */
    @BeforeEach
    public void beforeEach() {
        this.testFactory.resetAllList();
        this.initDataBeforeEach();
    }

    /**
     * Method launch after each test
     */
    @AfterEach
    public void afterEach(){
        this.testFactory.resetAllList();
    }

    /**
     * Method used to prepare the data of tests
     */
    abstract protected void initDataBeforeEach();

}
