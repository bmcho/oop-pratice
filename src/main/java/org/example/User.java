package org.example;

public class User {

    private String password;

    public void initPassword(PasswordGenerateInterface passwordGenerateInterface) {
        String password = passwordGenerateInterface.generatePassword();

        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
