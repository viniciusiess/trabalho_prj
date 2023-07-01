package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class BlobToFileConverter {

    public static File convertBlobToFile(Blob blob) throws SQLException, IOException {
        File file = File.createTempFile("tempfile", null);
        file.deleteOnExit();


        try (OutputStream os = new FileOutputStream(file)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            InputStream is = blob.getBinaryStream();
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }

        return file;
    }
}