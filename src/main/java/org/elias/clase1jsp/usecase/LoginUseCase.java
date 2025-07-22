package org.elias.clase1jsp.usecase;

import org.elias.clase1jsp.entity.User;

public interface LoginUseCase {
    User findUserByUsername(String name);
    boolean handleLogin(String username, String pass);
    boolean verifyPass(String pass, String hashedPass);
    boolean validateInput(String username, String pass);
}
