package com.fenrir.example02.generator;

import com.fenrir.example02.generator.model.DataModel;
import com.fenrir.example02.generator.model.FileEntry;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;

// http://aes.online-domain-tools.com/
public class EncryptionGeneratorContext extends GeneratorContext {
    private static final String SECRET_KEY = "Bar12345Bar12345";
    private static final String TRANSFORMATION = "AES";

    @Override
    public void generate(DataModel dataModel) throws Exception {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            generatorStrategy.generate(dataModel, out);
            byte[] content = encrypt(out.toByteArray());
            FileEntry fileEntry = new FileEntry(generatorStrategy.extension(), content);
            entries.add(fileEntry);
        }
    }

    private byte[] encrypt(byte[] content) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKey secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(content);
    }
}
