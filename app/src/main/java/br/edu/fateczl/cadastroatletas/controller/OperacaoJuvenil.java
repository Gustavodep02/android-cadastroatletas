package br.edu.fateczl.cadastroatletas.controller;

import br.edu.fateczl.cadastroatletas.model.AtletaJuvenil;

import java.util.ArrayList;
import java.util.List;
/*
 *@author:<Gustavo de Paula>
 */
public class OperacaoJuvenil implements IOperacao<AtletaJuvenil> {
    private List<AtletaJuvenil> lista;

    public OperacaoJuvenil() {
        this.lista = new ArrayList<>();
    }
    @Override
    public void cadastrar(AtletaJuvenil atleta) {
        lista.add(atleta);
    }

    @Override
    public List<AtletaJuvenil> listar() {
        return this.lista;
    }
}
