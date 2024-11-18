package org.techspark.auth.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuthRequest {

    @Schema(description = "User Name", example = "user")
    private String username;
    @Schema(description = "Secured Password", example = "password")
    private String password;

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
