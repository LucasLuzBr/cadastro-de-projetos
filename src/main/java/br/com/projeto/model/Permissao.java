package br.com.projeto.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_permissao;

    @Size(max = 50)
    @NonNull
    private String nome;

    @ManyToMany(mappedBy = "permissoes")
    private List<Usuario> usuarios;

    public Long getId_permissao() {
        return id_permissao;
    }

    public void setId_permissao(Long id_permissao) {
        this.id_permissao = id_permissao;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
