/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author gabriel.rvital
 */
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Blob;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("static-access")
public class Upload {

    public Upload() {
        setDefaultStorageCredentials();
    }

    private static Storage storage = null;
    private static Credentials credentials = null;
    //Project Id can be obtained from your GCP console dashboard.
    private static String projectId = "canes-268220";

    //Create the bucket using the REST API or manually using the Google Cloud Storage Browser Interface.
    private static String bucketName = "imagedb";

    //Following 4 parameters can be obtained from the Private Key file.
    //Client Id will usually be a numeric string
    private static String clientId = "110461176084612512506";

    //Client Email Id is the email Id generated when you create the service account. This will be in the format of: *.iam.gserviceaccount.com
    private static String clientEmailId = "app-732@canes-268220.iam.gserviceaccount.com";

    //Private key can be obtained from the key file. This will be a very long string within the file. Paste the entire string here.
    private static String privateKey = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDEerGRFResRg3j\ny7PId9eT1gdqrb69tMFcupMZ3YvScRggCP06E1pBbwUsTpVntsbMNKaKpdIt3vfR\nj7ZUgcKUaoABLhIUErupM6zOQgmb7NTTfAJ77cPnR/TeeStqoMeC4Ccnf0wnFokJ\nst9pqy2gJdRjZ8NpvzU5eBeXk5Dy4F4fh7jz1DpJIq9nQSQ/zAe7nEQo5Zh47saq\n5n//IzMJt9dLb66KhCPvi5oI5wbEpqzjUGoWCYCh8NDEbCP1AJuPtHOKiU+mnVXX\nUmVTi991qTXvM3eArdlyDaZI/C+5lYiIDDMwbpswT2rjhIoVfPiYI2pWCfsEOCNe\nZGe4XJ8xAgMBAAECggEAEBT72kR39NOiGOpoO4klpdXfswloIqZ8Kj8iQbx60J2N\nrDeYJIwHd/IiogMHox7YjEfl9tTGTJdiwO4qriWV2+iQtCgFdkunPRz78MECgNcE\nf4/3sxWd0p0264vO9DIXSnzW75pxjQSA8ICJ3WATwrc9+Gn6mnn6XQsZoUBEncB/\nKwWYXK0+2uCNsPLTA9TANz0bvdPhmGhU1rO3YWnpm0VbNimzKa43FR78jBQ7hJYM\nkUndGA1Lc27CxnkOQRtxdmgEePeVE1L3mL2e64joVPfdNOxpsmJsok+XYz4YCmob\n8OMbd453+wLxXIUePAHiwAf1Y/x/efCJvG30DghFXQKBgQD+NA6T3PZYdlVCiKb5\nnxWEStfO4vRQhHhRMVQsu46zEuyV1n3b+tZTDfG5VTs16dF8B93OyS/h3sYHCWdh\nEa+7jjdf3CIp2NE/cZkS5qgo1WmHPSovN4ACX6q03Hi8nac+M4mfLRXlRIQjLVl4\nKnNifeRzatDp4ZrvmnjfxFLbTQKBgQDF3jGNr5ml7L6UfePdc6Mx9x321U89d0OW\nAjmLP8vDNZySNzsJ16/5jKNnByx2ISNUnBkklJh0K5yM8ZYdo1hjXA54y7z87u1X\nr1a3xTjDREO7BKndnzTg4TJjErLx2Zmi0kJBCcfC19ZhwiXVB3Bk3jAmcSbi2La5\nz1EfdrN5dQKBgQCymChVwjxhUmH8aL3HSvl3BI4ykElN+IP/p0SYWP2c2oLVkujC\nEK1blMRrjXIYIrpHBc/UZIz7h+RhNT4oeKCaiQRmmOZ3uBjrFgiRuvQSHD4UAekN\nW1TYVhY9E1jQS4MgtFzQNIDZnxWnEUl2n3yJiiFi5Xz5lMOh60lZDTmZUQKBgGgi\nbxvtTcTIWuiVdKXopPu33Xo5exGTQeuh0h0Z/ygGgBdnn9enPwLr5FdlrB2jhQ+T\nc5wP5EhHZ4W541JH1E2+dhNWzmijah/atJ3U2vHRbH/xjWCI2HB9tGH1xl2IMtZB\nKANInWxK4ZXjcruxxZIgaWDh7iA3A7u4gy4272+9AoGAXxImOrVgxpzXdvY8LMeu\nHl6DeXFocbgqZlHkDWHKHrqlCZJuZWXrDro0pO8E4ZpPJNC5jAMNrgx9/DRfFLa4\nngE/V+aDrm0ufRgIc/LQeI9zRnYPp269XZOEc8tReIqks7Q1ZEoN5+iA6bHUsU7o\nNVeDT/Vu+RurQz108OkGh1c=\n-----END PRIVATE KEY-----\n";

    //Private Key Id can be obtained from the key file. This is ususally a numeric string.
    private static String privateKeyId = "bba42fa5798299120984519b4e80f24b26050411";

    /**
     * This method sets the storage credentials for the default storage object.
     */
    private void setDefaultStorageCredentials() {
        try {
            credentials = ServiceAccountCredentials.fromPkcs8(clientId, clientEmailId, privateKey, privateKeyId, null);
            storage = StorageOptions.newBuilder()
                    .setCredentials(credentials)
                    .setProjectId(projectId).build().getService();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean uploadFile(String filePath, byte[] file) {
        try {
            setDefaultStorageCredentials();
            storage.create(BlobInfo.newBuilder(bucketName, filePath).build(),
                    new ByteArrayInputStream(file));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Downloads a given file from Google Cloud Storage.
     *
     * @param filePath The desired file path for the file to be downloaded. File
     * path should be absolute path and should include folders, sub-folders, and
     * file name
     * @return the downloaded file in byte array format
     */
    public byte[] downloadFile(String filePath) throws FileNotFoundException, IOException {
        setDefaultStorageCredentials();
        return storage.get(bucketName).get(filePath).getContent();
    }

    /**
     * Generates a temporary link to a file in Google Cloud Storage. This will
     * allow temporary access to the file without actually exposing the file.
     * Users accessing this link need not sign in using any credentials.
     * <p>
     * After the expiry time, this link will be expired and general public
     * cannot access the file.
     *
     * @param filePath The desired file path for the file to be uploaded. File
     * path should be absolute path and should include folders, sub-folders, and
     * file name
     * @return String containing the signed url for the file specified.
     */
    public String getTemporaryFileLink(String filePath) throws Exception {
        setDefaultStorageCredentials();
        Blob blob = storage.get(bucketName).get(filePath);
        String blobName = blob.getName();
        URL signedUrl = storage.signUrl(BlobInfo.newBuilder(bucketName, blobName).build(), 5, TimeUnit.MINUTES);
        return signedUrl.toExternalForm();
    }

    /**
     * Deletes a given file from Google Cloud Storage.
     *
     * @param filePath The desired file path for the file to be deleted. File
     * path should be absolute path and should include folders, sub-folders, and
     * file name
     * @return true if the file has been successfully deleted; false otherwise
     */
    public boolean deleteFile(String filePath) {
        setDefaultStorageCredentials();
        return storage.delete(storage.get(bucketName).get(filePath).getBlobId());
    }

}
