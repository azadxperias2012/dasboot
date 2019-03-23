package com.boot;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRespository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//import static org.junit.Assert.assertEquals;

public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRespository shipwreckRespository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        when(shipwreckRespository.findById(1l)).thenReturn(Optional.of(sw));

        Shipwreck shipwreck = sc.get(1L);

        verify(shipwreckRespository).findById(1l);

        //assertEquals(1l, shipwreck.getId().longValue());

        // hamcrest assertions
        assertThat(shipwreck.getId(), is(1l));
    }

}
