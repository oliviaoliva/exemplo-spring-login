package br.edu.ifpb.pweb2.controladores.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean isValidCredentials(String user, String senha) {
        return user.equals("fred") && senha.equals("123");
    }
}
