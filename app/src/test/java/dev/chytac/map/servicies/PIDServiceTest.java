package dev.chytac.map.servicies;

import junit.framework.TestCase;

import java.io.IOException;

public class PIDServiceTest extends TestCase {


    public void testGetStation() throws IOException {
        PIDService pidService = new PIDService();

        pidService.getStation();
    }
}