package org.pasa.sispasa.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Andre Gomes
 *
 */
public abstract class Utils {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private Utils() {
    }

    /**
     * Retorna uma data no formato Java.Util.Date a partir de uma String de Data
     * no formato SqlServer ()
     *
     * @param dataSql
     * @param String dataSql
     * @return Date
     * @throws ParseException
     */
    public static Date converteStringDataSqlToJavaDate(String dataSql) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dataSql);
    }

    /**
     * @author André Gomes
     * @param formatado
     * @return
     */
    public static String desformataCep(String formatado) {
        String desformatado = formatado.trim();
        desformatado = desformatado.replace("-", "");
        return desformatado;
    }

    /**
     * @author André Gomes
     * @param desformatado
     * @return
     */
    public static String formataCpf(String cpf) {
        String bloco1 = cpf.substring(0, 3);
        String bloco2 = cpf.substring(3, 6);
        String bloco3 = cpf.substring(6, 9);
        String bloco4 = cpf.substring(9, 11);
        cpf = bloco1 + "." + bloco2 + "." + bloco3 + "-" + bloco4;
        return cpf;
    }

    /**
     * @author André Gomes
     * @param desformatado
     * @return
     */
    public static String formataCnpj(String cnpj) {
        String bloco1 = cnpj.substring(0, 2);
        String bloco2 = cnpj.substring(2, 5);
        String bloco3 = cnpj.substring(5, 8);
        String bloco4 = cnpj.substring(8, 12);
        String bloco5 = cnpj.substring(12, 14);
        cnpj = bloco1 + "." + bloco2 + "." + bloco3 + "/" + bloco4 + "-" + bloco5;
        return cnpj;
    }

    /**
     * @author André Gomes
     * @param formatado
     * @return
     */
    public static String desformataCpfCnpj(String formatado) {
        String desformatado = formatado.trim();
        desformatado = desformatado.replace("-", "");
        desformatado = desformatado.replace(".", "");
        desformatado = desformatado.replace("/", "");
        return desformatado;
    }

    /**
     * @author André Gomes
     * @param formatado
     * @return
     */
    public static String desformataTelefone(String formatado) {
        String desformatado = formatado.trim();
        desformatado = desformatado.replace("(", "");
        desformatado = desformatado.replace(")", "");
        desformatado = desformatado.replace("-", "");
        desformatado = desformatado.replace(" ", "");
        return desformatado;
    }

    /**
     * @author André Gomes
     * @param formatado
     * @return
     */
    public static String formataTelefone(String desformatado) {

        desformatado = desformatado.trim();
        String ddd = retornaDDDTelefone(desformatado);
        String numero = retornaNumeroTelefone(desformatado);

        ddd = "(" + ddd + ") ";

        if (8 == numero.length()) {
            numero = (numero.substring(0, 4) + "-" + numero.substring(4, 8));
        } else {
            numero = (numero.substring(0, 5) + "-" + numero.substring(5, 9));
        }
        return ddd + numero;
    }

    /**
     * Retorna o DDD de um telefone desformatado com ddd+numero (Ex:2199998888 -
     * Retorna: 21)
     *
     * @param String telefone
     * @return String
     */
    public static String retornaDDDTelefone(String telefone) {
        return telefone.substring(0, 2);
    }

    /**
     * Retorna o DDD de um telefone desformatado com ddd+numero (Ex:2199998888 -
     * Retorna: 99998888)
     *
     * @param String telefone
     * @return String
     */
    public static String retornaNumeroTelefone(String telefone) {
        return telefone.substring(2);
    }

    /**
     * @author André Gomes
     * @param str
     * @param peso
     * @return
     */
    private static int calcularDigitoCpfCnpj(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    /**
     * @author André Gomes
     * @param cpf
     * @return
     */
    public static boolean isValidCPF(String cpf) {

        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        if ("00000000000".equals(cpf) || "11111111111".equals(cpf) || "22222222222".equals(cpf)
                || "33333333333".equals(cpf) || "44444444444".equals(cpf) || "55555555555".equals(cpf)
                || "66666666666".equals(cpf) || "77777777777".equals(cpf) || "88888888888".equals(cpf)
                || "99999999999".equals(cpf)) {

            return false;
        }

        Integer digito1 = calcularDigitoCpfCnpj(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigitoCpfCnpj(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    /**
     * @author André Gomes
     * @param cnpj
     * @return
     */
    public static boolean isValidCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }
        Integer digito1 = calcularDigitoCpfCnpj(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigitoCpfCnpj(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    /**
     * @author André Gomes
     * @param cnpj
     * @return
     */
    public static boolean isValidData(Date data) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {

            String dataFormatada = sdf.format(data);

            if (StringUtils.isBlank(dataFormatada)) {
                return false;
            }

            sdf.parse(dataFormatada);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * @author André Gomes
     * @param cnpj
     * @return
     */
    public static boolean isDataFutura(Date data) throws ParseException {
        int resultCompare = data.compareTo(new Date());

        if (resultCompare <= 0) {
            return false;
        }
        return true;
    }

    /**
     *
     * Metodo responsavel por verificar se o e-mail informado eh valido
     *
     * @author Regiane Mesquita
     * @param String email
     * @return boolean
     */
    public static boolean isEmailValido(final String email) {
        final Pattern ptt = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,3}$");
        final Matcher mtc = ptt.matcher(email);
        return mtc.matches();
    }

    public static boolean isBlank(String valor) {
        return StringUtils.isBlank(valor);
    }

}
