package com.bitwarden.passwordless.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "passwordless.api")
public class PasswordlessApiConfig {
    String url;
    String publicKey;
    String privateKey;
}
