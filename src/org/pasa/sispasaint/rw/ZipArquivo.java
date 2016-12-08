package org.pasa.sispasaint.rw;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author 90J00318
 */
public class ZipArquivo {

    public ZipArquivo() {
    }

    public void zip(String fileName, String pathIn, String pathOut) {
        byte[] buffer = new byte[1024];
        try {
            FileOutputStream fos = new FileOutputStream(pathOut);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze = new ZipEntry(fileName);
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(pathIn);

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            in.close();
            zos.closeEntry();
            zos.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
