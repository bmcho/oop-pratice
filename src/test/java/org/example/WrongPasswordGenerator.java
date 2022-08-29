package org.example;

public class WrongPasswordGenerator implements PasswordGenerateInterface{
    @Override
    public String generatePassword() {
        return "abc";
    }
}
