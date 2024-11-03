package br.edu.fateczl.cadastroatletas.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.cadastroatletas.model.AtletaComum;
/*
 *@author:<Gustavo de Paula>
 */
public class OperacaoComum implements IOperacao<AtletaComum> {

    private List<AtletaComum> lista;

    public OperacaoComum() {
        this.lista = new ArrayList<>();
    }
    @Override
    public void cadastrar(AtletaComum atleta) {
        lista.add(atleta);
    }

    @Override
    public List<AtletaComum> listar() {
        return this.lista;
    }
}
