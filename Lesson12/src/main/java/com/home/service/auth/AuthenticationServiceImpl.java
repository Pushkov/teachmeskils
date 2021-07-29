package com.home.service.auth;

import com.home.exception.WrongLoginException;
import com.home.exception.WrongPasswordException;

import static com.home.util.Constants.*;

public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public boolean checkAuthorization(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() >= LOGIN_LENGTH) {
            if (!login.matches(PATTERN_LOGIN)) {
                throw new WrongLoginException("В поле ЛОГИН введены некорректные данные");
            }
        } else {
            throw new WrongLoginException("количество символов в логине должено быть не менее " + LOGIN_LENGTH);
        }
        if (password.length() >= PASSWORD_LENGTH) {
            if (!password.matches(PATTERN_PASSWORD)) {
                throw new WrongPasswordException("В поле ПАРОЛЬ введены некорректные данные");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        } else {
            throw new WrongPasswordException("количество символов в пароле должено быть не менее " + PASSWORD_LENGTH);
        }
        return true;
    }
}
