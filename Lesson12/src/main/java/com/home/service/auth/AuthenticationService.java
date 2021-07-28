package com.home.service.auth;

public interface AuthenticationService {

    void login();

    void clearCredentials();

    boolean isConnected();

    String getUserLogin();
}
