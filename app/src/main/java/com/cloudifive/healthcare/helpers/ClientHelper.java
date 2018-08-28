package com.cloudifive.healthcare.helpers;



import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.cloudifive.healthcare.utils.LogUtils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by david on 4/26/2016.
 */
public class ClientHelper {


   // private OkHttpClient clientBuilder = getUnsafeOkHttpClient();
   OkHttpClient clientBuilder = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final javax.net.ssl.SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(hostnameVerifier);
            builder.protocols(Arrays.asList(Protocol.HTTP_1_1));

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        System.out.println("Service Url : " + url);
        System.out.println("Payload : " + json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .addHeader("ContentType", "x-www-form-urlencoded" +
//                        "")
//                .build();
        Response response = clientBuilder.newCall(request).execute();
        System.out.println("Data Call"+response.body().string());
        return response.body().string();
    }
    public String post(String url) throws IOException {
      //  RequestBody body = RequestBody.create(JSON, json);
        LogUtils.i("Service Url : " + url);
        //LogUtils.i("Payload : " + json);
        Request request = new Request.Builder()
                .url(url)
                 .addHeader("ContentType", "application/json")
                .build();
        Response response = clientBuilder.newCall(request).execute();
        return response.body().string();
    }

    public String post(String url, String json, String token) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        LogUtils.i("Service Url : " + url);
        LogUtils.i("Payload : " + json);
        LogUtils.i("Token " + token);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("ContentType", "application/json")
//                .addHeader("Authorization", "Token " + token)
                .build();
        //  httppost.addHeader("ContentType", "multipart/form-data");
        //httppost.addHeader("Accept", "application/json");
        Response response = clientBuilder.newCall(request).execute();
        return response.body().string();
    }

    public String put(String url, String json, String token) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        LogUtils.i("Service Url : " + url);
        LogUtils.i("Payload : " + json);
        LogUtils.i("Token " + token);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .addHeader("Authorization", "Bearer " + token)
//                .addHeader("Authorization", "Token " + token)
                .build();
        Response response = clientBuilder.newCall(request).execute();
        return response.body().string();
    }

    public String putCarePlan(String url, String json, String token) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        LogUtils.i("Service Url : " + url);
        LogUtils.i("Payload : " + json);
        LogUtils.i("Bearer " + token);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .addHeader("Authorization", "Bearer " + token)
                .build();
        Response response = clientBuilder.newCall(request).execute();
        return response.body().string();
    }

    public String delete(String url, String token) throws IOException {
        LogUtils.i("Service Url : " + url);
        LogUtils.i("Token " + token);
        //LogUtils.i("Payload : " + json);
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .addHeader("Authorization", "Bearer " + token)
//                .addHeader("Authorization", "Token " + token)
                .build();
        Response response = clientBuilder.newCall(request).execute();
        return response.body().string();
    }

    public String deleteHistory(String url, String json, String token) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        LogUtils.i("Service Url : " + url);
        LogUtils.i("Token " + token);
        LogUtils.i("Payload : " + json);
        Request request = new Request.Builder()
                .url(url)
                .delete(body)
                .addHeader("Authorization", "Bearer " + token)
                .build();
        Response response = clientBuilder.newCall(request).execute();
        return response.body().string();
    }

    public String getSubjectiveDataList(String url, String token) throws IOException {

        Request request = new Request.Builder()
                .url(url)

                .addHeader("Authorization", "Bearer " + token)
                .build();
        LogUtils.i("Service Url : " + url);
        LogUtils.i("Bearer " + token);
        Response response = clientBuilder.newCall(request).execute();
        return response.body().string();
    }
    public String get(String url) throws IOException {
    
        Request request = new Request.Builder()
                .url(url)

                .addHeader("ContentType", "application/json")
                .build();
        LogUtils.i("Service Url : " + url);
        Response response = clientBuilder.newCall(request).execute();
        return response.body().string();
    }

    public String get(String url, String token) throws IOException {
        Request request = new Request.Builder()
                .url(url)
//                .addHeader("Authorization", "Token " + token)
                .addHeader("ContentType", "application/json")
                .build();
        LogUtils.i("Service Url : " + url);
        LogUtils.i("Token " + token);

        Response response = clientBuilder.newCall(request).execute();
        return response.body().string();
    }
}
