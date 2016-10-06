/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasaint.model.Empresa;

/**
 *
 * @author 90J00318
 */
public interface EmpresaDAO {
    Empresa obter(Long id);
    void cadastrar(Empresa e);
    void atualizar(Empresa e);
    void apagar(Empresa e);
    List<Empresa> listar();
    Empresa existe(Empresa e);
}
