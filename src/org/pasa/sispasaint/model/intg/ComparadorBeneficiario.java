package org.pasa.sispasaint.model.intg;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.pasa.sispasa.core.model.Beneficiario;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ComparadorBeneficiario {

    public ComparadorBeneficiario() {
    }

    public int comparar(Beneficiario a, Beneficiario b) {

        return new CompareToBuilder()
                //ENDERECO
                .append(a.getPessoa().getEnderecos().get(0).getCep(), b.getPessoa().getEnderecos().get(0).getCep())
                .append(a.getPessoa().getEnderecos().get(0).getBairro().toLowerCase(), b.getPessoa().getEnderecos().get(0).getBairro().toLowerCase())
                .append(a.getPessoa().getEnderecos().get(0).getLogradouro().toLowerCase(), b.getPessoa().getEnderecos().get(0).getLogradouro().toLowerCase())
                .append(a.getPessoa().getEnderecos().get(0).getNumero(), b.getPessoa().getEnderecos().get(0).getNumero())
                .append(a.getPessoa().getEnderecos().get(0).getMunicipio().getNome().toLowerCase(), b.getPessoa().getEnderecos().get(0).getMunicipio().getNome().toLowerCase())
                .append(a.getPessoa().getEnderecos().get(0).getEstado().getId().toLowerCase(), b.getPessoa().getEnderecos().get(0).getEstado().getId().toLowerCase())
                //TELEFONE
                .append(a.getPessoa().getTelefones().get(0).getNumeroTelefone(), b.getPessoa().getTelefones().get(0).getNumeroTelefone())
                //ESCOLARIDADE
                .append(a.getPessoa().getIndConclusaoEscolaridade(), a.getPessoa().getIndConclusaoEscolaridade())
                //ESTADO CIVIL
                .append(a.getPessoa().getEstadoCivil().getId(), a.getPessoa().getEstadoCivil().getId())
                //DOCUMENTOS
                .append(a.getPessoa().getCpf(), a.getPessoa().getCpf())
                .append(a.getPessoa().getDocumentoPIS(), b.getPessoa().getDocumentoPIS())
                .toComparison();
    }
}
