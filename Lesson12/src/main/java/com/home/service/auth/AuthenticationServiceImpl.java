package com.home.service.auth;

import com.home.exception.IncorrectPasswordConfirmationException;
import com.home.exception.IncorrectPasswordDataException;
import com.home.exception.WrongLoginException;
import com.home.exception.WrongPasswordException;
import com.home.model.Credentials;
import com.home.util.Constants;
import lombok.AllArgsConstructor;

import static com.home.util.Constants.Validation.PATTERN_LOGIN;
import static com.home.util.Constants.Validation.PATTERN_PASSWORD;
import static com.home.util.IOUtils.getStringFromConsole;

@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final Credentials credentials;

    public AuthenticationServiceImpl() {
        this.credentials = new Credentials();
    }

    @Override
    public void login() {
        try {
            this.credentials.setLogin(getLogin());
            this.credentials.setPassword(getPassword());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage() + e.getCause().getMessage());
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("************************************************************************");
        }
    }


    private String getLogin() {
        String login = getStringFromConsole(Constants.Banners.LOGIN);
        if (!login.matches(PATTERN_LOGIN)) {
            clearCredentials();
            throw new WrongLoginException("В поле LOGIN введены некорректные данные");
        }
        return login;
    }

    private String getPassword() {
        String password = getStringFromConsole(Constants.Banners.PASSWORD);
        if (!password.matches(PATTERN_PASSWORD)) {
            clearCredentials();
            throw new WrongPasswordException("Ошибка создания пароля: ", new IncorrectPasswordDataException("введены некорректные данные"));
        }
        if (!getConfirmPassword(password)) {
            clearCredentials();
            throw new WrongPasswordException("Ошибка создания пароля: ", new IncorrectPasswordConfirmationException("пароли не совпадают"));
        }
        return password;
    }

    private boolean getConfirmPassword(String password) {
        return password.equals(getStringFromConsole(Constants.Banners.CONFIRM_PASSWORD));
    }

    @Override
    public void clearCredentials() {
        this.credentials.setLogin(null);
        this.credentials.setPassword(null);
    }

    @Override
    public boolean isConnected() {
        return this.credentials.getLogin() != null && this.credentials.getPassword() != null;
    }

    @Override
    public String getUserLogin() {
        return this.credentials.getLogin();
    }
}
