package br.edu.fateczl.cadastroatletas.controller;

import java.util.List;
/*
 *@author:<Gustavo de Paula>
 */
public interface IOperacao<T> {
    public void cadastrar (T t);
    public List<T> listar();
}
