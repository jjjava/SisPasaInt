package org.pasa.sispasaint.bean;

import java.util.List;

import org.pasa.sispasa.core.model.DadosBancarios;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface DadosBancariosBean {
    void cadastrar( DadosBancarios db);
    void atualizar(DadosBancarios db);
    void apagar(DadosBancarios db);
    DadosBancarios obter(Long id);
    List<DadosBancarios> listar();
}
