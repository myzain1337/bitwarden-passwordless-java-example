package com.bitwarden.passwordless.service;

import com.bitwarden.passwordless.PasswordlessClient;
import com.bitwarden.passwordless.error.PasswordlessApiException;
import com.bitwarden.passwordless.model.SignInVerify;
import com.bitwarden.passwordless.model.SignInVerifyToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PasswordlessApiService {
    private final PasswordlessClient passwordlessClient;

    @Autowired
    public PasswordlessApiService(PasswordlessClient passwordlessClient) {
        this.passwordlessClient = passwordlessClient;
    }

    public SignInVerifyToken signIn(String token) throws PasswordlessApiException, IOException {
        return passwordlessClient.signInVerify(new SignInVerify(token));
    }
}
