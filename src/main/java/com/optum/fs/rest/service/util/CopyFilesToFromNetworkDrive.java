package com.optum.fs.rest.service.util;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

import java.io.*;
import java.net.MalformedURLException;

public class CopyFilesToFromNetworkDrive {
    public static void main(String[] args) throws Exception {
        //   listFile();
        // listFiles();
        copy3();
//        final String userName = "fds_service";
//        final String password = "4Lq6eKGA";
//        final String sourcePath = "/Users/apatra9/Documents/Salary_Data.csv";
//        final String destinationPath = "smb://Uhc00502/data/UHT_TRMCB/Incoming/";
//        // copyFileUsingJcifs(userName, password);
//        createCopyOnNetwork("uhc00502.uhc.com", userName, password, sourcePath, destinationPath);


    }

    public static void copyFileUsingJcifs(final String userName,
                                          final String password) throws IOException {

        final String user = userName + ":" + password;
        String sourcePath = "/Users/apatra9/Documents/Salary_Data.csv";
        final String destinationPath = "smb://Uhc00502/data/UHT_TRMCB/Incoming";
        final NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(
                user);
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


    public static void copyFiles(String fileLocationSource,
                                 String fileLocationDestination, int numberOfFilesToCopy) {
        File inputLocation = new File(fileLocationSource);
        if (inputLocation.isDirectory()) {
            System.out.println("Listing the files...");
            File[] attachmentFiles = inputLocation.listFiles();
            System.out.println("Total files in the folder: "
                    + attachmentFiles.length);
            for (File aFile : attachmentFiles) {
                if (!aFile.isDirectory()) {
                    String fileName = aFile.getName();
                    String sourceFileName = aFile.getAbsolutePath();
                    String destinationFileName = fileLocationDestination
                            + fileName;
                    copyFile(sourceFileName, destinationFileName);
                }
                if (numberOfFilesToCopy >= 0) {
                    if (--numberOfFilesToCopy == 0) {
                        break;
                    }
                }
            }
        }
        System.out.println("Completed...");
    }

    /**
     * @param sourceFileName
     * @param destionFileName Copies a single file from source location to a destination
     *                        location.
     */
    private static void copyFile(String sourceFileName, String destionFileName) {
        try {
            System.out.println("Reading..." + sourceFileName);
            File sourceFile = new File(sourceFileName);
            File destinationFile = new File(destionFileName);
            InputStream in = new FileInputStream(sourceFile);
            OutputStream out = new FileOutputStream(destinationFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            System.out.println("Copied: " + sourceFileName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void copy3() throws IOException {
//        String url = "smb://Uhc00502/data/UHT_TRMCB/Incoming/";
//        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, "fds_service", "4Lq6eKGA");
//        SmbFile dir = new SmbFile(url, auth);
//        for (SmbFile f : dir.listFiles())
//        {
//            System.out.println(f.getName());
//        }
        // String localPath = "D: \\ project \\ src.txt";
        // You can use '/' instead of '\\' which needs escaping as PATH delimiter
        String localPath = "/Users/apatra9/Documents/Salary_Data.csv";
        String remotePath = "smb://fds_service:4Lq6eKGA@10.106.113.111/Uhc00502/data/UHT_TRMCB/Incoming/Salary_Data.csv";
        try {
            FileInputStream ifs = new FileInputStream(localPath);
            SmbFile dst = new SmbFile(remotePath);
            SmbFileOutputStream ofs = new SmbFileOutputStream(dst);
            byte[] data = new byte[1024];
            for (; ; ) {
                int len = ifs.read(data);
                if (len == -1) {
                    break;
                }
                ofs.write(data, 0, len);
            }
            ifs.close();
            ofs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean createCopyOnNetwork(String domain, String username, String password, String src, String dest) throws Exception {
        FileInputStream in = null;
        SmbFileOutputStream out = null;
        BufferedInputStream inBuf = null;
        try {
            //jcifs.Config.setProperty("jcifs.smb.client.disablePlainTextPasswords","true");
            NtlmPasswordAuthentication authentication = new NtlmPasswordAuthentication(domain, username, password); // replace with actual values
            SmbFile file = new SmbFile(dest, authentication); // note the different format
            in = new FileInputStream(src);
            inBuf = new BufferedInputStream(new FileInputStream(src));
            out = (SmbFileOutputStream) file.getOutputStream();
            byte[] buf = new byte[5242880];
            int len;
            while ((len = inBuf.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                if (inBuf != null)
                    inBuf.close();
                if (out != null)
                    out.close();
            } catch (Exception ex) {
            }
        }
        System.out.print("\n File copied to destination");
        return true;
    }

    public static void listFiles() throws IOException {
        //  FileInputStream in = new FileInputStream("/Users/apatra9/Documents/Salary_Data.csv");
        BufferedInputStream inBuf = new BufferedInputStream(new FileInputStream("/Users/apatra9/Documents/Salary_Data.csv"));
        byte[] buf = new byte[5242880];
        String user = "fds_service";
        String pass = "4Lq6eKGA";
        String sharedFolder = "Uhc00502/data/UHT_TRMCB/Incoming/" + "Salary_Data.csv";
        String path = "smb://10.106.113.111/" + sharedFolder;
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("10.106.113.111", user, pass);
        SmbFile smbFile = new SmbFile(path, auth);
        SmbFileOutputStream smbfos = new SmbFileOutputStream(smbFile);
//        int len;
//        while ((len = inBuf.read(buf)) > 0){
//            smbfos.write(buf, 0, len);
//        }
        smbfos.write("testing....and writing to a file".getBytes());
        System.out.println("completed ...nice !");

    }

    public static void listFile() throws MalformedURLException, SmbException {
        String url = "smb://Uhc00502/data/UHT_TRMCB/Incoming/";
        String user = "uhc00502.uhc.com/fds_service";
        String pass = "4Lq6eKGA";
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("uhc00502.uhc.com/Uhc00502/data/UHT_TRMCB/Incoming/", user, pass);
        SmbFile dir = new SmbFile(url, auth);
        for (SmbFile f : dir.listFiles()) {
            System.out.println(f.getName());
        }
    }
}
