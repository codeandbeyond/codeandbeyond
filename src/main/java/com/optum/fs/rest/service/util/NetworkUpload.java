package com.optum.fs.rest.service.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import jcifs.Config;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;


public class NetworkUpload {

    public static void main(String[] args) throws IOException {
        final String userName = "uhc00502.uhc.com\\fds_service";
        final String password = "4Lq6eKGA";
        final String domain = "uhc00502.uhc.com";
        //source path begins with / as i am using macbook (mac osx), in your case it will be windows drive path
        final String sourcePath = "/Users/apatra9/Documents/Salary_Data.csv";
        final String destinationPath = "smb://Uhc00502/data/UHT_TRMCB/Incoming/Salary_Data.csv";

        copyFileUsingJcifs(domain,userName, password, sourcePath, destinationPath);

        System.out.println("The file has been copied using JCIFS");
    }

    public static void copyFileUsingJcifs(final String domain,final String userName,
                                          final String password, final String sourcePath,
                                          final String destinationPath) throws IOException {

        System.setProperty("jcifs.smb.client.responseTimeout", "120000"); // default: 30000 millisec.
        System.setProperty("jcifs.smb.client.soTimeout", "140000");
        final NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(
                domain, userName, password);
        final SmbFile sFile = new SmbFile(destinationPath, auth);
        final SmbFileOutputStream smbFileOutputStream = new SmbFileOutputStream(
                sFile);
        final FileInputStream fileInputStream = new FileInputStream(new File(
                sourcePath));

        final byte[] buf = new byte[16 * 1024 * 1024];
        int len;
        while ((len = fileInputStream.read(buf)) > 0) {
            smbFileOutputStream.write(buf, 0, len);
        }
        fileInputStream.close();
        smbFileOutputStream.close();
    }

}