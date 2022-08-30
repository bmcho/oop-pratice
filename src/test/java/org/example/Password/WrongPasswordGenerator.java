package org.example.Password;

import org.example.Password.PasswordGenerateInterface;

public class WrongPasswordGenerator implements PasswordGenerateInterface {
    @Override
    public String generatePassword() {
        return "abc";
    }
}
