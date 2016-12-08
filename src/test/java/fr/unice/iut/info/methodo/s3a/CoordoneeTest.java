package fr.unice.iut.info.methodo.s3a;

import fr.unice.iut.info.methodo.s3a.model.Coordonee;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by axelm on 18/11/2016.
 */
public class CoordoneeTest {
    private Coordonee testCoor;

    @Before
    public void setUp() throws Exception {
        testCoor = new Coordonee(5,5,"Marseille");

    }

    @After
    public void tearDown() throws Exception {

    }

}