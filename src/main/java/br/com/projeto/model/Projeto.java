package br.com.projeto.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_projeto;

    @Size(max = 50)
    @NonNull
    private String nome;

    @NonNull
    @Column(name = "data_inicio")
    private Date dataInicio;

    @NonNull
    @Column(name = "data_final")
    private Date dataFinal;

    @ManyToMany(mappedBy = "projetos")
    private List<Funcionario> funcionarios;

    public Long getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(Long id_projeto) {
        this.id_projeto = id_projeto;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(@NonNull Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @NonNull
    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(@NonNull Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
