package br.edu.fateczl.cadastroatletas.model;

import androidx.annotation.NonNull;

/*
 *@author:<Gustavo de Paula>
 */
public class AtletaJuvenil extends Atleta{
    private int anosPraticados;

    public int getAnosPraticados() {
        return anosPraticados;
    }
    public void setAnosPraticados(int anosPraticados) {
        this.anosPraticados = anosPraticados;
    }

    @NonNull
    @Override
    public String toString() {
        return "AtletaJuvenil{" +
                " nome='" + getNome() + '\n' +
                ", dataNascimento='" + getDataNascimento() + '\n' +
                ", bairro='" + getBairro() + '\n' +
                "anosPraticados=" + anosPraticados +
                '}';
    }
}
