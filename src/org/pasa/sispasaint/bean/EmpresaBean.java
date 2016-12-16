package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.Empresa;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface EmpresaBean {
    Empresa obter(Long id);
    Empresa obter(Empresa e);
    void cadastrar(Empresa e);
    void atualizar(Empresa e);
    void apagar(Empresa e);
    List<Empresa> listar();
    Empresa existe(String codigo);
}
