package org.techspark.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(
        title = "TechSpark Open API Service",
        version = "1.0",
        description = "An Open Api documentation for demonstration purpose",
        contact = @Contact(name = "Support Team", email = "codrixtechtrainer@gmail.com"),
        license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")
))
public class OpenAPIConfig {
}
