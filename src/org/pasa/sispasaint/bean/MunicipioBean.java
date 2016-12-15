package org.pasa.sispasaint.bean;

import java.util.List;
import org.pasa.sispasa.core.model.Municipio;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public interface MunicipioBean {
    Municipio obter(Municipio m);
    void cadastrar(Municipio m);
    void atualizar(Municipio m);
    void apagar(Municipio m);
    List<Municipio> listar();
    Municipio existe(String nome);
}
