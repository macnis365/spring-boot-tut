package com.boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.model.ShipwreckStub;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ShipwreckControllerTests {
    @InjectMocks
    private  ShipwreckController shipwreckController;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet(){
        Shipwreck shipwreck = new Shipwreck();
        shipwreck.setId(1L);
        Mockito.when(shipwreckRepository.getOne(1L)).thenReturn(shipwreck);

        Shipwreck wreck = shipwreckController.get(1L);
        Mockito.verify(shipwreckRepository, times(1)).getOne(1L);
        assertEquals(1L, wreck.getId().longValue());
    }
}
