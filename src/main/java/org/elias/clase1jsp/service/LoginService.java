package org.elias.clase1jsp.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.elias.clase1jsp.controller.LoginServlet;
import org.elias.clase1jsp.entity.User;
import org.elias.clase1jsp.usecase.LoginUseCase;

import java.util.List;
import java.util.logging.Logger;

@NoArgsConstructor
@AllArgsConstructor
public class LoginService implements LoginUseCase {
    private List<User> users;
    private SecurityService securityService;
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public User findUserByUsername(String nameInput) {
        try {
            return users
                    .stream()
                    .filter(user -> user.getName().equals(nameInput))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            log.warning("User not found exception: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean handleLogin(String username, String pass) {
        try {
            User u = findUserByUsername(username);
            if(u == null || !validateInput(username, pass)) return false;
            log.info(String.format("New login attempt: %s %s \n", username, pass));
            verifyPass(pass, u.getPassHashed());
            log.info("Successful login for user: " + u.getName());
            return true;
        } catch (Exception e) {
            log.info("Error at handleLogin method: "+ e.getMessage());
            return false;
        }
    }

    @Override
    public boolean verifyPass(String pass, String hashedPass) {
        return securityService.checkPass(pass, hashedPass);
    }

    @Override
    public boolean validateInput(String username, String pass) {
        return (username != null && username.matches(".*\\S.*"))
                && (pass != null && pass.matches(".*\\S.*"));
    }
}
