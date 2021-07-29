package com.home.service.auth;

import com.home.exception.WrongLoginException;
import com.home.exception.WrongPasswordException;

public interface AuthenticationService {

    boolean checkAuthorization(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException;
}
