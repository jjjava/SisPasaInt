package org.pasa.sispasaint.map;

import java.util.HashMap;
import java.util.Map;
import org.pasa.sispasaint.rw.PosicaoCampo;

/**
 *
 * @author Hudson Schumaker
 */
public class MapaCamposEndVLI {

    private Map<String, PosicaoCampo> mapa;

    public MapaCamposEndVLI() {
        mapa = new HashMap<>();
        mapa.put(CamposEndVLI.EMPRESA, new PosicaoCampo(1, 3));
        mapa.put(CamposEndVLI.MATRICULA, new PosicaoCampo(3, 9));
        mapa.put(CamposEndVLI.COD_BENEFICIARIO, new PosicaoCampo(9, 11));
        mapa.put(CamposEndVLI.TELEFONE1, new PosicaoCampo(11, 30));
        mapa.put(CamposEndVLI.TELEFONE2, new PosicaoCampo(31, 50));
        mapa.put(CamposEndVLI.BRANCO, new PosicaoCampo(51, 59));
        mapa.put(CamposEndVLI.ENDERECO, new PosicaoCampo(60, 119));
        mapa.put(CamposEndVLI.BAIRRO, new PosicaoCampo(120, 149));
        mapa.put(CamposEndVLI.CIDADE, new PosicaoCampo(150, 179));
        mapa.put(CamposEndVLI.UF, new PosicaoCampo(180, 182));
        mapa.put(CamposEndVLI.CEP, new PosicaoCampo(182, 190));
    }

    public Map<String, PosicaoCampo> getMapa() {
        return mapa;
    }

    public void setMapa(Map<String, PosicaoCampo> mapa) {
        this.mapa = mapa;
    }
}
