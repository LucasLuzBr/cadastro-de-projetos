package br.com.projeto.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UsuarioSistema extends User {

    private static final long serialVersionUID = 2074183660319003905L;
    private String nome;

    public UsuarioSistema(String nome, String login, String senha, Collection<? extends GrantedAuthority> autorizacoes){
        super(login, senha, autorizacoes);
        this.nome = nome;
    }

    public String getName() {
        return this.nome;
    }
}
