package geco;

import java.util.Random;

public class PasswordGeneration {

    public String getRandomPassword(){
        String password = "";
        Random rand = new Random();
        for (int i = 0; i<8; i++ ){
            char c = (char)(rand.nextInt(26) + 97);
            password += c;
        }
        System.out.println(password);
        return password;
    }

    //public static void main(String[] args) {
      //  PasswordGeneration pg = new PasswordGeneration();
        //pg.getRandomPassword();
    //}
}
