package org.pasa.sispasaint.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.pasa.sispasaint.config.Configuracao;

/**
 *
 * @author 90J00318
 */
public class LerArquivos {

    private Long id;
    private String benNomeArq, endNomeArq;
    private boolean read;

    public LerArquivos() {
        read = true;
    }

    public void ler(Long id) {
        this.id = id;
        ler(Configuracao.getInstance().getPathIn(id),
                Configuracao.getInstance().getNomeArqBen(id),
                Configuracao.getInstance().getNomeArqEnd(id));
    }

    public void ler(String path, String benNomeArq, String endNomeArq) {
        this.benNomeArq = benNomeArq;
        this.endNomeArq = endNomeArq;
        ler(new File(path + "/" + benNomeArq), new File(path + "/" + endNomeArq));
    }

    public void ler(File ben, File end) {

        try {

            BufferedReader brBen = new BufferedReader(new FileReader(ben));
            BufferedReader brEnd = new BufferedReader(new FileReader(end));

            while (read) {
                String benLine = brBen.readLine();
                String endLine = brEnd.readLine();

                if (benLine == null || endLine == null) {
                    read = false;
                }
                
                System.out.println(benLine +endLine);

            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
        }
    }

    private String lerBen(File ben) {

        return "";
    }

    private String acerta190Pos(String line) {
        while (line.length() < 190) {
            line = line + " ";
        }
        return line;
    }

    private String normalizaLinha(String line) {
        line = " " + line;
        return line;
    }
}
