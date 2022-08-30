package org.example.Password;

import org.example.Password.PasswordGenerateInterface;

public class CorrectPasswordGenerator implements PasswordGenerateInterface {
    @Override
    public String generatePassword() {
        return "aaaabbbbcc";
    }
}
