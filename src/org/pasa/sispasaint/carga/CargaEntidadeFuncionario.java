package org.pasa.sispasaint.carga;

import java.util.ArrayList;
import java.util.List;
import org.pasa.sispasa.core.enumeration.EnumOrigemInformacoes;
import org.pasa.sispasa.core.enumeration.EnumTipoDocumento;
import org.pasa.sispasa.core.enumeration.EnumTipoVinculoEmpregaticio;
import org.pasa.sispasa.core.model.Beneficiario;
import org.pasa.sispasa.core.model.DadosBancarios;
import org.pasa.sispasa.core.model.Documento;
import org.pasa.sispasa.core.model.Empresa;
import org.pasa.sispasa.core.model.Endereco;
import org.pasa.sispasa.core.model.Estado;
import org.pasa.sispasa.core.model.Funcionario;
import org.pasa.sispasa.core.model.Municipio;
import org.pasa.sispasa.core.model.NivelEscolaridade;
import org.pasa.sispasa.core.model.OrigemInformacoes;
import org.pasa.sispasa.core.model.Telefone;
import org.pasa.sispasa.core.model.TipoDocumento;
import org.pasa.sispasa.core.model.TipoVinculoEmpregaticio;
import org.pasa.sispasaint.bean.impl.EmpresaBeanImpl;
import org.pasa.sispasaint.bean.impl.EstadoBeanImpl;
import org.pasa.sispasaint.bean.impl.ModeloBenEndBeanImpl;
import org.pasa.sispasaint.bean.impl.MunicipioBeanImpl;
import org.pasa.sispasaint.dao.impl.FuncionarioDAOImpl;
import org.pasa.sispasaint.model.intg.ModeloBenEnd;
import org.pasa.sispasaint.util.DateUtil;
import org.pasa.sispasaint.util.SisPasaIntCommon;
import org.pasa.sispasaint.util.StringUtil;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class CargaEntidadeFuncionario {
    
    private Funcionario funcionario;
    
    public boolean newFuncionario(ModeloBenEnd modeloBenEnd) {
        Empresa empresa = new EmpresaBeanImpl().existe(modeloBenEnd.getEmpresa());
        if (empresa == null) {
            return false;
        } else {
            //EMPRESA
            funcionario = new Funcionario();
            funcionario.setEmpresa(empresa);
            //ENDERECO
            if (newEndereco(modeloBenEnd) == null) {
                return false;
            } else {
                funcionario.addEndereco(newEndereco(modeloBenEnd));
            }
            //DOCUMENTOS
            funcionario.setCpf(modeloBenEnd.getCpf());
            funcionario.addDocumento(newPis(modeloBenEnd));
            //TELEFONES
            funcionario.setTelefones(newTelefones(modeloBenEnd));
            //ATRIBUTOS 
            setAtributos(modeloBenEnd);
            //DADOS BANCARIOS
            funcionario.setDadosBancarios(newDadosBancarios(modeloBenEnd));
            //ORIGEM INFORMACOES
            funcionario.setOrigemInformacoes(newOrigemInformacoes());
            //VINCULO
            funcionario.setTipoVinculoEmpregaticio(newTipoVinculoEmpregaticio(modeloBenEnd));
            //BENEFICIARIOS
            List<ModeloBenEnd> benef = new ModeloBenEndBeanImpl().listarBeneficiarios(modeloBenEnd);
            
            for (ModeloBenEnd f : benef) {
                Beneficiario b = new CargaEntidadeBeneficiario().newBeneficiario(f);
                if (b == null) {
                    return false;
                } else {
                    funcionario.addBeneficiario(b);
                }
            }
            
            
            //MATRICULAS
            funcionario.setMatriculaOrigem(modeloBenEnd.getMatriculaPeople());//IMPORTANTE
            funcionario.setMatriculaAtualizadora(modeloBenEnd.getMatriculaAtulizador());
            funcionario.setMatriculaPasa(modeloBenEnd.getMatriculaPasa());
            
            //INSERT
            funcionario.setIdUsuario(SisPasaIntCommon.USER_CARGA);
            funcionario.setIndAtivo(SisPasaIntCommon.ATIVO);
            funcionario.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
            funcionario.setDataInclusaoSistema(DateUtil.obterDataAtual());
            return new FuncionarioDAOImpl().cadastrar(funcionario);
        }
    }
    
    private Endereco newEndereco(ModeloBenEnd modelo) {
        Estado estado = new EstadoBeanImpl().obter(modelo.getUf());
        Municipio municipio = new MunicipioBeanImpl().existe(modelo.getCidade());
        if (municipio == null) {
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setLogradouro(modelo.getEndereco());
        endereco.setBairro(modelo.getBairro());
        endereco.setCep(modelo.getCep());
        endereco.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        endereco.setIndAtivo(SisPasaIntCommon.ATIVO);
        endereco.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        endereco.setEstado(estado);
        endereco.setMunicipio(municipio);
        return endereco;
    }
    
    private Documento newPis(ModeloBenEnd modelo) {
        Documento pis = new Documento();
        TipoDocumento tpPIS = new TipoDocumento();
        pis.setNumero(modelo.getPis());
        pis.setNumero(modelo.getPis());
        tpPIS.setId(EnumTipoDocumento.PIS_PASEP.getIndice());
        tpPIS.setDescricao(EnumTipoDocumento.PIS_PASEP.getDescricao());
        pis.setTipoDocumento(tpPIS);
        pis.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        pis.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        return pis;
    }
    
    private List<Telefone> newTelefones(ModeloBenEnd modelo) {
        List<Telefone> listaTelefones = new ArrayList<>();
        Telefone tel1 = new Telefone();
        tel1.setNumeroTelefone(modelo.getTelefone1());
        tel1.setIndAtivo(SisPasaIntCommon.ATIVO);
        tel1.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        tel1.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        listaTelefones.add(tel1);
        
        Telefone tel2 = new Telefone();
        tel1.setNumeroTelefone(modelo.getTelefone1());
        tel2.setNumeroTelefone(modelo.getTelefone2());
        tel2.setIndAtivo(SisPasaIntCommon.ATIVO);
        tel2.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        tel2.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        listaTelefones.add(tel2);
        return listaTelefones;
    }
    
    private void setAtributos(ModeloBenEnd modelo) {
        //ATRIBUTOS 
        funcionario.setNome(modelo.getNomeBeneficiario());
        funcionario.setNomeAbreviado(modelo.getNomeBeneficiarioAbreviado());
        funcionario.setNomeMae(modelo.getNomeDaMae());
        funcionario.setSexo(modelo.getSexo());
        funcionario.setDataNascimento(DateUtil.toDate(modelo.getDataNascimento()));
        funcionario.setDireitoAbaterIR(modelo.getDireitoAbaterIR());
        funcionario.setDataAdmissao(DateUtil.toDate(modelo.getDataAdmissao()));
        funcionario.setFinanceira(modelo.getFinanceira());
        funcionario.setContratoTrabalho(modelo.getContratoTrabalho());
        funcionario.setEmpresaAtualizadora(modelo.getEmpresaAtualizador());
        funcionario.setMatriculaAtualizadora(modelo.getMatriculaAtulizador());
        funcionario.setCodDireitoPasa(modelo.getCodigoDireitoPasa());
        funcionario.setMatriculaPasa(modelo.getMatriculaPasa());
        funcionario.setMatriculaOrigem(modelo.getMatriculaOrigem());
        funcionario.setMatriculaPasa(modelo.getMatricula());
        funcionario.setUnidadeControle(modelo.getUnidadeDeControle());
        funcionario.setCentroCusto(modelo.getCentroDeCusto());
        funcionario.setNivelEscolaridade(newNivelEscolaridade(modelo));
        funcionario.setIndConclusaoEscolaridade(StringUtil.parserIndicadorConclusao(modelo.getIndicadorConclusao()));
    }
    
    private NivelEscolaridade newNivelEscolaridade(ModeloBenEnd modelo) {
        NivelEscolaridade nivelEscolaridade = new NivelEscolaridade();
        nivelEscolaridade.setId(Long.parseLong(modelo.getGrauEscolaridade()));
        return nivelEscolaridade;
    }
    
    private DadosBancarios newDadosBancarios(ModeloBenEnd modelo) {
        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setCodBanco(modelo.getBanco());
        dadosBancarios.setAgencia(modelo.getAgenciaBancaria());
        dadosBancarios.setConta(modelo.getContaCorrente());
        dadosBancarios.setTipoConta(SisPasaIntCommon.CONTACORRENTE);
        dadosBancarios.setIndAtivo(SisPasaIntCommon.ATIVO);
        dadosBancarios.setDataUltimaAtualizacao(DateUtil.obterDataAtual());
        dadosBancarios.setIdUsuario(SisPasaIntCommon.USER_CARGA);
        return dadosBancarios;
    }
    
    private TipoVinculoEmpregaticio newTipoVinculoEmpregaticio(ModeloBenEnd modelo) {
        TipoVinculoEmpregaticio tipoVinculoEmpregaticio = new TipoVinculoEmpregaticio();
        tipoVinculoEmpregaticio.setId(EnumTipoVinculoEmpregaticio.EmpregadoAtivo.getIndice());
        tipoVinculoEmpregaticio.setCodExterno(modelo.getVinculo());
        return tipoVinculoEmpregaticio;
    }
    
    private OrigemInformacoes newOrigemInformacoes() {
        OrigemInformacoes origemInformacoes = new OrigemInformacoes();
        origemInformacoes.setId(EnumOrigemInformacoes.CARGA.getIndice());
        origemInformacoes.setDescricao(EnumOrigemInformacoes.CARGA.getDescricao());
        return origemInformacoes;
    }
}
