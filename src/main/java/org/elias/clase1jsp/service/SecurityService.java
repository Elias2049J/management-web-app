package org.elias.clase1jsp.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

import java.util.logging.Logger;
@NoArgsConstructor
@AllArgsConstructor
public class SecurityService {
    private Logger log;

    public String encrypt(String pass){
        return BCrypt.hashpw(pass, BCrypt.gensalt(10));
    }

    public boolean checkPass(String pass, String hash) {
        return BCrypt.checkpw(pass, hash);
    }
}
