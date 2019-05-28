package pl.wedel.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DogRepoTest {

    @Autowired
    private DogRepo dogRepo;

    @Test
    public void get() {
        Dog dog = new Dog("Karol");
        dogRepo.save(dog);

        Assert.assertEquals(1, dogRepo.findAll().size());
    }
}
