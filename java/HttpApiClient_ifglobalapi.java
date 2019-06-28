//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.ifengtech.bigdepots.user.controller;

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;


public class HttpApiClient_ifglobalapi extends ApacheHttpClient {
    public final static String HOST = "150ad3f45707481489016d398f6b9b1d-cn-beijing.alicloudapi.com";
    static HttpApiClient_ifglobalapi instance = new HttpApiClient_ifglobalapi();

    public static HttpApiClient_ifglobalapi getInstance() {
        return instance;
    }

    public void init(HttpClientBuilderParams httpClientBuilderParams) {
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }


    public void addUserInfo(Integer age, String username, ApiCallback callback) {
        String path = "/user/info";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM, path);
        request.addParam("age", String.valueOf(age), ParamPosition.QUERY, false);
        request.addParam("username", username, ParamPosition.QUERY, false);


        sendAsyncRequest(request, callback);
    }

    public ApiResponse addUserInfo_syncMode(Integer age, String username) {
        String path = "/user/info";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM, path);
        request.addParam("age", String.valueOf(age), ParamPosition.QUERY, false);
        request.addParam("username", username, ParamPosition.QUERY, false);


        return sendSyncRequest(request);
    }

    public void getBkStore(String userCode, ApiCallback callback) {
        String path = "/store";
        ApiRequest request = new ApiRequest(HttpMethod.GET, path);
        request.addParam("userCode", userCode, ParamPosition.QUERY, true);


        sendAsyncRequest(request, callback);
    }

    public ApiResponse getBkStore_syncMode(String userCode) {
        String path = "/store";
        ApiRequest request = new ApiRequest(HttpMethod.GET, path);
        request.addParam("userCode", userCode, ParamPosition.QUERY, true);


        return sendSyncRequest(request);
    }

    public void getUserInfo(Long id, ApiCallback callback) {
        String path = "/user/[id]/*";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM, path);
        request.addParam("id", String.valueOf(id), ParamPosition.PATH, true);


        sendAsyncRequest(request, callback);
    }

    public ApiResponse getUserInfo_syncMode(Long id) {
        String path = "/user/[id]/*";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM, path);
        request.addParam("id", String.valueOf(id), ParamPosition.PATH, true);


        return sendSyncRequest(request);
    }

}