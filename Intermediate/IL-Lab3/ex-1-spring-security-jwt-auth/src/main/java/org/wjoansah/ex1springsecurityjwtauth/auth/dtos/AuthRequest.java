package org.wjoansah.ex1springsecurityjwtauth.auth.dtos;

import java.io.Serializable;

public record AuthRequest(String email, String password) {
}
