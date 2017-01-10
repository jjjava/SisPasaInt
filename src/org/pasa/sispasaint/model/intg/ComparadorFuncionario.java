package org.pasa.sispasaint.model.intg;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.pasa.sispasa.core.model.Funcionario;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class ComparadorFuncionario {

    public ComparadorFuncionario() {
    }

    public int comparar(Funcionario a, Funcionario b) {

        return new CompareToBuilder()
                .append(a.getTipoVinculoEmpregaticio().getCodExterno(), b.getTipoVinculoEmpregaticio().getCodExterno())
                //DADOS BANCARIOS
                .append(a.getDadosBancarios().getCodBanco(), b.getDadosBancarios().getCodBanco())
                .append(a.getDadosBancarios().getAgencia(), b.getDadosBancarios().getAgencia())
                .append(a.getDadosBancarios().getConta(), b.getDadosBancarios().getConta())
                //ENDEREÇO
                .append(a.getEnderecos().get(0).getCep(), b.getEnderecos().get(0).getCep())
                .append(a.getEnderecos().get(0).getBairro().toLowerCase(), b.getEnderecos().get(0).getBairro().toLowerCase())
                .append(a.getEnderecos().get(0).getLogradouro().toLowerCase(), b.getEnderecos().get(0).getLogradouro().toLowerCase())
                .append(a.getEnderecos().get(0).getNumero(), b.getEnderecos().get(0).getNumero())
                .append(a.getEnderecos().get(0).getMunicipio().getNome().toLowerCase(), b.getEnderecos().get(0).getMunicipio().getNome().toLowerCase())
                .append(a.getEnderecos().get(0).getEstado().getId().toLowerCase(), b.getEnderecos().get(0).getEstado().getId().toLowerCase())
                //TELEFONE
                .append(a.getTelefones().get(0).getNumeroTelefone(), b.getTelefones().get(0).getNumeroTelefone())
                //ESCOLARIDADE
                .append(a.getIndConclusaoEscolaridade(), a.getIndConclusaoEscolaridade())
                //ESTADO CIVIL
                .append(a.getEstadoCivil().getId(), a.getEstadoCivil().getId())
                //DOCUMENTOS
                .append(a.getCpf(), a.getCpf())
                .append(a.getDocumentoPIS(), b.getDocumentoPIS())
                .toComparison();
    }
}
