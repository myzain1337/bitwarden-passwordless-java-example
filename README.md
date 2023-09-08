# Passwordless Java SDK Example

Please read the documentation here: https://docs.passwordless.dev

## Getting Started

This example uses *Spring Boot 3 Web* and provides UI and REST interfaces to interact with
the [Passwordless Java SDK][passwordless-java-sdk] to the *Passwordless API*.

JDK 17 or newer is required to run the application.

1. Get your own API keys here: https://admin.passwordless.dev/signup
2. Change the value of the `passwordless.api.private-key`
   in [application.properties](src/main/resources/application.properties) with your API Private Key.
3. (optional) In case of self-hosting, change the value of the `passwordless.api.url` with the base url where
   your *Passwordless API* instance is running.
3. Start the application

```shell
./mvnw spring-boot:run
```

4. The application will now listen on port `8080` e.g. http://localhost:8080, where you can *Sign In* and *Register*
   users within your Application.

[passwordless-java-sdk]:https://github.com/passwordless/passwordless-java-
