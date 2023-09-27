package com.codegym.util;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

public class CommonUntil {
    public static String encode64(String raw) {
        return Base64.getEncoder().encodeToString(raw.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode64(String raw) {
        byte[] decodeBytes;
        String decodedString = "";
        try {
            decodeBytes = Base64.getDecoder().decode(raw.getBytes(StandardCharsets.UTF_8));
            decodedString = new String(decodeBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.fillInStackTrace();
        }

        return decodedString;
    }

    public static String encodeMD5(String raw) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.fillInStackTrace();
        }

        assert md != null;
        md.update(raw.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest);
    }

    public static String getMimeTypeFromFileName(String fileName) {
        String res = "";
        String extension = Optional.of(fileName).filter(f -> f.contains(".")).map(f -> f.substring(fileName.lastIndexOf("."), fileName.length())).orElse("");
        switch (extension) {
            case ".gif":
                res = "image/gif";
                break;
            case ".jpeg":
                res = "image/jpeg";
                break;
            case ".png":
                res = "image/png";
                break;
            case ".tiff":
                res = "image/tiff";
                break;
            default:
                res = "image/svg+xml";
        }
        return res;
    }
}
