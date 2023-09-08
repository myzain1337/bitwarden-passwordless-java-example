package com.bitwarden.passwordless.rest;

import com.bitwarden.passwordless.PasswordlessClient;
import com.bitwarden.passwordless.error.PasswordlessApiException;
import com.bitwarden.passwordless.error.PasswordlessProblemDetails;
import com.bitwarden.passwordless.model.RegisterToken;
import com.bitwarden.passwordless.model.RegisterTokenResponse;
import com.bitwarden.passwordless.model.SignInVerify;
import com.bitwarden.passwordless.model.SignInVerifyToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "passwordless/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PasswordlessRestController {

    private final PasswordlessClient passwordlessClient;

    @Autowired
    public PasswordlessRestController(PasswordlessClient passwordlessClient) {
        this.passwordlessClient = passwordlessClient;
    }

    @PostMapping(path = "login")
    public SignInVerifyToken login(@RequestBody SignInVerify signInVerify) throws PasswordlessApiException, IOException {
        return passwordlessClient.signInVerify(signInVerify);
    }

    @PostMapping(path = "register")
    public RegisterTokenResponse register(@RequestBody RegisterToken registerToken) throws PasswordlessApiException, IOException {
        return passwordlessClient.createRegisterToken(registerToken);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordlessApiException.class)
    public PasswordlessProblemDetails handlePasswordlessApiException(PasswordlessApiException exception) {
        return exception.getDetails();
    }
}
