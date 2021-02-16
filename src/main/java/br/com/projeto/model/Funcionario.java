package br.com.projeto.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_funcionario;

    @Size(max = 50)
    @NonNull
    private String nome;

    @Size(max = 50)
    @NonNull
    private String sobrenome;

    @Size(max = 11)
    @NonNull
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private Cargo cargo;

    @ManyToMany
    @JoinTable(name = "funcionario_projeto",
        joinColumns = @JoinColumn(name = "id_funcionario"),
        inverseJoinColumns = @JoinColumn(name = "id_projeto"))
    private List<Projeto> projetos;

    public Long getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Long id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(@NonNull String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @NonNull
    public String getCpf() {
        return cpf;
    }

    public void setCpf(@NonNull String cpf) {
        this.cpf = cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
