package geco;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest  {

    /**
     * Rigourous Test :-)
     */

    private LoginService loginService;

    @Test
    public void loginExistsTestFalse()
    {
        //GIVEN
        String[] logins = {"cyysi45", "lnl", "eleve3"};
        loginService = new LoginService(logins);
        //WHEN
        boolean exist = loginService.loginExists("lnlyguyg");
        //THEN
        assertFalse( exist );
    }

    @Test
    public void loginExistsTestTrue()
    {
        //GIVEN
        String[] logins;
        //WHEN
        logins = new String[]{"cyysi45", "lnl"};
        loginService = new LoginService(logins);
        boolean exist = loginService.loginExists("lnl");
        //THEN
        assertTrue( exist );
    }

    @Test
    public void addLogin() {
        //GIVEN
        String[] logins = {"cyysi45", "lnl"};
        //WHEN
        loginService = new LoginService(logins);
        loginService.addLogin("fer45");
        //THEN
        assertTrue(loginService.loginExists("fer45"));
    }

    @Test
    public void addLoginFalse() {
        //GIVEN
        String[] logins = {"cyysi45", "lnl"};
        //WHEN
        loginService = new LoginService(logins);
        loginService.addLogin("fer45");
        //THEN
        assertFalse(loginService.loginExists("hy56"));
    }

    @Test
    public void findAllLoginsStartingWith() {
        //GIVEN
        String[] logins = {"cyysi45", "lnl", "lucia"};
        List<String> liste;
        //WHEN
        loginService = new LoginService(logins);
        liste = loginService.findAllLoginsStartingWith("l");
        //THEN
        assertEquals("[lnl, lucia]",liste.toString());
    }

    @Test
    public void findAllLoginsStartingWithFalse() {
        //GIVEN
        String[] logins = {"cyysi45", "lnl", "lucia"};
        List<String> liste;
        //WHEN
        loginService = new LoginService(logins);
        liste = loginService.findAllLoginsStartingWith("l");
        //THEN
        assertNotEquals("[cyysi45]",liste.toString());
    }

    @Test
    public void findAllLogins() {
        //GIVEN
        String[] logins = {"cyysi45", "lnl", "lucia"};
        List<String> liste;
        //WHEN
        loginService = new LoginService(logins);
        liste = loginService.findAllLogins();
        //THEN
        assertEquals("[cyysi45, lnl, lucia]",liste.toString());
    }

    @Test
    public void findAllLoginsFalse() {
        //GIVEN
        String[] logins = {"lucia"};
        List<String> liste;
        //WHEN
        loginService = new LoginService(logins);
        liste = loginService.findAllLogins();
        //THEN
        assertNotEquals("[cyysi45, lnl, lucia]",liste.toString());
    }
}
