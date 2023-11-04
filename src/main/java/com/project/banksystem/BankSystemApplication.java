package com.project.banksystem;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
            title = "Native Spring Bank Application",
            description = "Backend REST APIs for Native Spring Bank",
            version = "v1.0",
            contact = @Contact(
                    name = "Wael Morjen & Malek Bougadouha",
                    email = "waelmorjen@gmail.com",
                    url = "https://github.com/Wael-Morjen/Secure-Bank-System"
            ),
            license = @License(
                    name = "MyBank Project",
                    url = "https://github.com/Wael-Morjen/Secure-Bank-System"
            )
    ),
    externalDocs = @ExternalDocumentation(
            description = "Native Spring Bank App Documentation",
            url = "https://github.com/Wael-Morjen/Secure-Bank-System"
    )
)
public class BankSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankSystemApplication.class, args);
    }

}
