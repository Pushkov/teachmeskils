package com.home;

import com.home.service.auth.AuthenticationService;
import com.home.service.auth.AuthenticationServiceImpl;

public class HomeWork12 {

    public static void main(String[] args) {
        AuthenticationService service = new AuthenticationServiceImpl();
        do {
            service.login();
        } while (!service.isConnected());
        System.out.println("User '" + service.getUserLogin() + "' connected");
    }
}
