package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.Empresa;


/**
 *
 * @author Hudson Schumaker
 */
public interface EmpresaDAO {
    Empresa obter(Long id);
    boolean cadastrar(Empresa e);
    boolean atualizar(Empresa e);
    void apagar(Empresa e);
    List<Empresa> listar();
    Empresa existe(String codigo);
}
