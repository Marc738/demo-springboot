package de.enexhd.serverapplication;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AuthenticationService {

    private ArrayList<User> authenticatedUsers;

    public AuthenticationService() {
        authenticatedUsers = new ArrayList<>();
        authenticatedUsers.add(new User("Marc", 20020807));
        authenticatedUsers.add(new User("Simon", 20040319));
        authenticatedUsers.add(new User("Anisa", 20040718));
        authenticatedUsers.add(new User("Matej", 20021112));
    }

    public ServiceResponse authenticate(long token) {
        if(0 < authenticatedUsers.stream().filter(user -> user.getToken() == token).count()) {
            return new ServiceResponse(0, "Your token is valid!");
        } else {
            return new ServiceResponse(1, "Your token is invalid!");
        }
    }

}
