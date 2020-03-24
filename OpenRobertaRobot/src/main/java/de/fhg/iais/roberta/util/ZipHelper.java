package de.fhg.iais.roberta.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class ZipHelper {

    private static final int BUFFER_SIZE = 1024;

    private ZipHelper() {
    }

    public static void zipFiles(String outputFile, List<String> inputFiles) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            for ( String srcFilename : inputFiles ) {
                File srcFile = new File(srcFilename);
                try (FileInputStream fis = new FileInputStream(srcFile)) {
                    ZipEntry zipEntry = new ZipEntry(srcFile.getName());
                    zos.putNextEntry(zipEntry);
                    byte[] bytes = new byte[BUFFER_SIZE];
                    int length;
                    while ( (length = fis.read(bytes)) >= 0 ) {
                        zos.write(bytes, 0, length);
                    }
                }
            }
        }
    }
}
