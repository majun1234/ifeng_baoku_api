//
//  Created by  fred on 2016/10/26.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.ifengtech.bigdepots.user.controller;

import com.alibaba.cloudapi.sdk.constant.SdkConstant;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Demo_ifglobalapi {

    public static void main(String[] args) {
        init();
        getBkStoreHttpTest();
    }


    public static void init() {
        //HTTP Client init
        HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
        httpParam.setAppKey("203710229");
        httpParam.setAppSecret("kto0uiwlsp7lnqk6oxsjqq0d1jttvj42");
        try{
            HttpApiClient_ifglobalapi instance = HttpApiClient_ifglobalapi.getInstance();
            instance.init(httpParam);
        }catch (Exception e){
            e.printStackTrace();
        }

//        //HTTPS Client init
//        HttpClientBuilderParams httpsParam = new HttpClientBuilderParams();
//        httpsParam.setAppKey("203710229");
//        httpsParam.setAppSecret("kto0uiwlsp7lnqk6oxsjqq0d1jttvj42");
//
//        /**
//         * HTTPS request use DO_NOT_VERIFY mode only for demo
//         * Suggest verify for security
//         */
//        //httpsParam.setRegistry(getNoVerifyRegistry());
//
//        HttpsApiClient_ifglobalapi.getInstance().init(httpsParam);


    }

    /**
     * 添加用户信息
     */
    public static void addUserInfoHttpTest() {
        HttpApiClient_ifglobalapi.getInstance().addUserInfo(1, "default", new ApiCallback() {
            public void onFailure(ApiRequest apiRequest, Exception e) {
                System.out.println("addUserInfoHttpTest-onFailure");
            }

            public void onResponse(ApiRequest apiRequest, ApiResponse apiResponse) {
                System.out.println("addUserInfoHttpTest-onResponse");
            }
        });
    }

    public static void addUserInfoHttpSyncTest() {
        ApiResponse response = HttpApiClient_ifglobalapi.getInstance().addUserInfo_syncMode(1, "default");
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void addUserInfoHttpsTest() {
        HttpsApiClient_ifglobalapi.getInstance().addUserInfo(1, "default", new ApiCallback() {
            public void onFailure(ApiRequest apiRequest, Exception e) {

            }

            public void onResponse(ApiRequest apiRequest, ApiResponse apiResponse) {

            }
        });
    }

    public static void addUserInfoHttpsSyncTest() {
        ApiResponse response = HttpsApiClient_ifglobalapi.getInstance().addUserInfo_syncMode(1, "default");
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void getBkStoreHttpTest() {
        HttpApiClient_ifglobalapi.getInstance().getBkStore("default", new ApiCallback() {
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println("getBkStoreHttpTest()-onResponse()");
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void getBkStoreHttpSyncTest() {
        ApiResponse response = HttpApiClient_ifglobalapi.getInstance().getBkStore_syncMode("default");
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getBkStoreHttpsTest() {
        HttpsApiClient_ifglobalapi.getInstance().getBkStore("default", new ApiCallback() {
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void getBkStoreHttpsSyncTest() {
        ApiResponse response = HttpsApiClient_ifglobalapi.getInstance().getBkStore_syncMode("default");
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void getUserInfoHttpTest() {
        HttpApiClient_ifglobalapi.getInstance().getUserInfo(1L, new ApiCallback() {
            public void onFailure(ApiRequest apiRequest, Exception e) {

            }

            public void onResponse(ApiRequest apiRequest, ApiResponse apiResponse) {

            }
        });
    }

    public static void getUserInfoHttpSyncTest() {
        ApiResponse response = HttpApiClient_ifglobalapi.getInstance().getUserInfo_syncMode(1L);
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getUserInfoHttpsTest() {
        HttpsApiClient_ifglobalapi.getInstance().getUserInfo(1L, new ApiCallback() {
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void getUserInfoHttpsSyncTest() {
        ApiResponse response = HttpsApiClient_ifglobalapi.getInstance().getUserInfo_syncMode(1L);
        try {
            System.out.println(getResultString(response));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static String getResultString(ApiResponse response) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append("Response from backend server").append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        result.append("ResultCode:").append(SdkConstant.CLOUDAPI_LF).append(response.getCode()).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        if (response.getCode() != 200) {
            result.append("Error description:").append(response.getHeaders().get("x-ca-error-message")).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        }

//        result.append("ResultBody:").append(SdkConstant.CLOUDAPI_LF).append(new String(response.getBody() , SdkConstant.CLOUDAPI_ENCODING));
        result.append("ResultBody:").append(SdkConstant.CLOUDAPI_LF).append(new String(response.getBody(), "UTF-8"));

        return result.toString();
    }

    private static Registry<ConnectionSocketFactory> getNoVerifyRegistry() {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.create();
        try {
            registryBuilder.register("http", PlainConnectionSocketFactory.INSTANCE).build();
            registryBuilder.register(
                    "https",
                    new SSLConnectionSocketFactory(new SSLContextBuilder().loadTrustMaterial(
                            KeyStore.getInstance(KeyStore.getDefaultType()), new TrustStrategy() {
                                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                                    return true;
                                }
                            }).build(),
                            new HostnameVerifier() {
                                public boolean verify(String paramString, SSLSession paramSSLSession) {
                                    return true;
                                }
                            }));

        } catch (Exception e) {
            throw new RuntimeException("HttpClientUtil init failure !", e);
        }
        return registryBuilder.build();
    }


    private static void trustAllHttpsCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        SSLContext sc = SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
    }

    static class miTM implements TrustManager,
            X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                X509Certificate[] certs, String authType)
                throws CertificateException {
            return;
        }

        public void checkClientTrusted(
                X509Certificate[] certs, String authType)
                throws CertificateException {
            return;
        }
    }
}
