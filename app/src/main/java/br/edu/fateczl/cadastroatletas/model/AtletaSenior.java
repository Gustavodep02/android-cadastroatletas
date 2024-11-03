package br.edu.fateczl.cadastroatletas.model;

import androidx.annotation.NonNull;

/*
 *@author:<Gustavo de Paula>
 */
public class AtletaSenior extends Atleta{
    private boolean problemasCardiacos;

    public boolean isProblemasCardiacos() {
        return problemasCardiacos;
    }

    public void setProblemasCardiacos(boolean problemasCardiacos) {
        this.problemasCardiacos = problemasCardiacos;
    }
    @NonNull
    @Override
    public String toString() {
        return "AtletaSenior{" +
                " nome='" + getNome() + '\n' +
                ", dataNascimento='" + getDataNascimento() + '\n' +
                ", bairro='" + getBairro() + '\n' +
                "problemasCardiacos=" + problemasCardiacos +
                '}';
    }
}
