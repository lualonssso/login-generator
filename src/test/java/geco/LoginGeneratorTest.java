package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private LoginService loginService;
    private LoginGenerator loginGenerator;

    @Before
    public void before(){
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"} );
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void CT1() {
        //GIVEN
        //WHEN
        loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul");
        //THEN
        assertTrue(loginService.findAllLogins().contains("PDUR"));
    }

    @Test
    public void CT2() {
        //GIVEN
        //WHEN
        loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean");
        //THEN
        assertTrue(loginService.findAllLogins().contains("JROL1"));
    }

    @Test
    public void CT1bis() {
        //GIVEN
        List<String> liste;
        //WHEN
        loginGenerator.generateLoginForNomAndPrenom("Ralling", "John");
        liste = loginService.findAllLoginsStartingWith("JRAL");
        //THEN
        assertEquals("[JRAL, JRAL1, JRAL2]", liste.toString());
    }

    @Test
    public void CT3() {
        //GIVEN
        //WHEN
        loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
        //THEN
        assertTrue(loginService.findAllLogins().contains("PDUR"));
    }

}