package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.Empresa;


/**
 *
 * @author 90J00318
 */
public interface EmpresaDAO {
    Empresa obter(Long id);
    boolean cadastrar(Empresa e);
    boolean atualizar(Empresa e);
    void apagar(Empresa e);
    List<Empresa> listar();
    Empresa existe(String codigo);
}
