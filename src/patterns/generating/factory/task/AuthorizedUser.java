package patterns.generating.factory.task;

import java.util.Scanner;

public class AuthorizedUser implements User{
    private String login;
    private String password;

    public AuthorizedUser() {
        this.login = promt("Enter login");
        this.password = promt("Enter password");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public User createUser() {
        System.out.println("You try to get access into production profile. Please, authorized");
        return new AuthorizedUser();
    }
    private String promt(String message){
        System.out.println(message);
        return new Scanner(System.in).next();
    }
}
