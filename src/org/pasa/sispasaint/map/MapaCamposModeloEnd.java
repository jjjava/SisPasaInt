package org.pasa.sispasaint.map;

import java.util.HashMap;
import java.util.Map;
import org.pasa.sispasaint.rw.PosicaoCampo;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class MapaCamposModeloEnd {

    private Map<String, PosicaoCampo> mapa;

    public MapaCamposModeloEnd() {
        mapa = new HashMap<>();
        mapa.put(CamposModelo.EMPRESA, new PosicaoCampo(1, 3));
        mapa.put(CamposModelo.MATRICULA, new PosicaoCampo(3, 9));
        mapa.put(CamposModelo.COD_BENEFICIARIO, new PosicaoCampo(9, 11));
        mapa.put(CamposModelo.TELEFONE1, new PosicaoCampo(11, 30));
        mapa.put(CamposModelo.TELEFONE2, new PosicaoCampo(31, 50));
        mapa.put(CamposModelo.BRANCO, new PosicaoCampo(51, 59));
        mapa.put(CamposModelo.ENDERECO, new PosicaoCampo(60, 119));
        mapa.put(CamposModelo.BAIRRO, new PosicaoCampo(120, 149));
        mapa.put(CamposModelo.CIDADE, new PosicaoCampo(150, 179));
        mapa.put(CamposModelo.UF, new PosicaoCampo(180, 182));
        mapa.put(CamposModelo.CEP, new PosicaoCampo(182, 190));
    }

    public Map<String, PosicaoCampo> getMapa() {
        return mapa;
    }

    public void setMapa(Map<String, PosicaoCampo> mapa) {
        this.mapa = mapa;
    }
}
