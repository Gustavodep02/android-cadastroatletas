package br.edu.fateczl.cadastroatletas.model;

import androidx.annotation.NonNull;

/*
 *@author:<Gustavo de Paula>
 */
public class AtletaComum extends Atleta{
    private String academia;
    private double recorde;

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public double getRecorde() {
        return recorde;
    }

    public void setRecorde(double recorde) {
        this.recorde = recorde;
    }
    @NonNull
    @Override
    public String toString() {
        return "AtletaComum{" +
                " nome='" + getNome() + '\n' +
                ", dataNascimento='" + getDataNascimento() + '\n' +
                ", bairro='" + getBairro() + '\n' +
                " academia='" + academia + '\n' +
                ", recorde=" + recorde +
                '}';
    }
}
