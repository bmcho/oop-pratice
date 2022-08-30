package org.example.password;

public class WrongPasswordGenerator implements PasswordGenerateInterface {
    @Override
    public String generatePassword() {
        return "abc";
    }
}
