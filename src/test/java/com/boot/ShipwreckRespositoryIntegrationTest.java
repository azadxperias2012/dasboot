package com.boot;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRespository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ShipwreckRespositoryIntegrationTest {

    @Autowired
    private ShipwreckRespository shipwreckRespository;

    @Test
    public void testFindAll() {
        List<Shipwreck> wrecks = shipwreckRespository.findAll();
        assertThat(wrecks.size(), Matchers.is(Matchers.greaterThanOrEqualTo(0)));
    }

}
