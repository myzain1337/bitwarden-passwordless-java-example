package com.bitwarden.passwordless.rest;

import com.bitwarden.passwordless.error.PasswordlessApiException;
import com.bitwarden.passwordless.error.PasswordlessProblemDetails;
import com.bitwarden.passwordless.model.SignInVerifyToken;
import com.bitwarden.passwordless.service.PasswordlessApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "passwordless/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PasswordlessRestController {

    private final PasswordlessApiService passwordlessApiService;

    @Autowired
    public PasswordlessRestController(PasswordlessApiService passwordlessApiService) {
        this.passwordlessApiService = passwordlessApiService;
    }

    @GetMapping(path = "signin/{token}")
    public SignInVerifyToken signIn(@PathVariable String token) throws PasswordlessApiException, IOException {
        return passwordlessApiService.signIn(token);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordlessApiException.class)
    public PasswordlessProblemDetails handlePasswordlessApiException(PasswordlessApiException exception) {
        return exception.getDetails();
    }
}
