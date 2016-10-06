package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasaint.model.Empresa;

/**
 *
 * @author 90J00318
 */
public interface EmpresaBean {
    Empresa obter(Empresa e);
    void cadastrar(Empresa e);
    void atualizar(Empresa e);
    void apagar(Empresa e);
    List<Empresa> listar();
    Empresa existe(Empresa e);
}
