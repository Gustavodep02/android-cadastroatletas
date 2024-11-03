package br.edu.fateczl.cadastroatletas.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.cadastroatletas.model.AtletaSenior;
/*
 *@author:<Gustavo de Paula>
 */
public class OperacaoSenior implements IOperacao<AtletaSenior> {

    private List<AtletaSenior> lista;

    public OperacaoSenior() {
        this.lista = new ArrayList<>();
    }
    @Override
    public void cadastrar(AtletaSenior atleta) {
        lista.add(atleta);
    }

    @Override
    public List<AtletaSenior> listar() {
        return this.lista;
    }
}
