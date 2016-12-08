package fr.unice.iut.info.methodo.s3a.controller;

import fr.unice.iut.info.methodo.s3a.model.Utilisateur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by axelm on 30/11/2016.
 */
public class UtilisateurTest {

    private  Utilisateur utiTest;
    private HashMap<String,Utilisateur> tabTest;




    @Before
    public void setUp() throws Exception {
       utiTest = new Utilisateur("axelmouchiroud@hotmail.fr","Serialz","axel");
      // utiTest.creerFichier();
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void save() throws Exception {
        utiTest.save();
        tabTest = utiTest.read();
        assertEquals(true,tabTest.containsKey("Serialz"));
    }

    @Test
    public void read() throws Exception {
        tabTest= utiTest.read();
        assertEquals(utiTest.toString(),tabTest.get("Serialz").toString());
    }

}