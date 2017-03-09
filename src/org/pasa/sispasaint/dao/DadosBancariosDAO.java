package org.pasa.sispasaint.dao;

import java.util.List;
import org.pasa.sispasa.core.model.DadosBancarios;


/**
 *
 * @author Hudson Schumaker
 */
public interface DadosBancariosDAO {
    boolean cadastrar( DadosBancarios db);
    boolean atualizar(DadosBancarios db);
    void apagar(DadosBancarios db);
    DadosBancarios obter(Long id);
    List<DadosBancarios> listar();
}
