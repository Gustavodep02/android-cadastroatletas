package br.edu.fateczl.cadastroatletas.model;

import androidx.annotation.NonNull;

import java.time.LocalDate;
/*
 *@author:<Gustavo de Paula>
 */
public class Atleta {

    private String nome;
    private LocalDate dataNascimento;
    private String bairro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    @NonNull
    @Override
    public String toString() {
        return "Atleta{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
