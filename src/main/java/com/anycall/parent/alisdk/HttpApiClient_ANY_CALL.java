//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.anycall.parent.alisdk;
import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.enums.WebSocketApiType;




public class HttpApiClient_ANY_CALL extends ApacheHttpClient{
    public final static String HOST = "openapi.any-call.com";
    static HttpApiClient_ANY_CALL instance = new HttpApiClient_ANY_CALL();
    public static HttpApiClient_ANY_CALL getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }

    /***
     *
     * 创建call单
     * @param userName
     * @param reportManTel
     * @param reportMan
     * @param reportTime
     * @param systemNumCode
     * @param repairSource
     * @param faultDescription
     * @param soundUrls
     * @param shopCode
     * @param photographUrls
     */
    public void createCall(String userName , String reportManTel ,
                                  String reportMan , String reportTime , String systemNumCode ,
                                  String repairSource , String faultDescription , String soundUrls ,
                                  String shopCode , String photographUrls,String soundLength,String idToken ,ApiCallback callback) {
//        String path = "/openapi/createReport";
//        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
//        request.addParam("repairSource" , repairSource , ParamPosition.QUERY , false);
//        request.addParam("reportMan" , reportMan , ParamPosition.QUERY , false);
//        request.addParam("reportTime" , reportTime , ParamPosition.QUERY , false);
//        request.addParam("systemNumCode" , systemNumCode , ParamPosition.QUERY , false);
//        request.addParam("reportManTel" , reportManTel , ParamPosition.QUERY , false);
//        request.addParam("faultDescription" , faultDescription , ParamPosition.QUERY , false);
//        request.addParam("soundUrls" , soundUrls , ParamPosition.QUERY , false);
//        request.addParam("shopCode" , shopCode , ParamPosition.QUERY , false);
//        request.addParam("photographUrls" , photographUrls , ParamPosition.QUERY , false);
//        request.addParam("idToken" , idToken , ParamPosition.QUERY , true);
//        request.addParam("soundLength" , soundLength , ParamPosition.QUERY , false);
//
//
//
//        sendAsyncRequest(request , callback);

        String path = "/openapi/createReport";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("faultDescription" , faultDescription , ParamPosition.QUERY , false);
        request.addParam("repairSource" , repairSource , ParamPosition.QUERY , false);
        request.addParam("reportTime" , reportTime , ParamPosition.QUERY , false);
        request.addParam("systemNumCode" , systemNumCode , ParamPosition.QUERY , false);
        request.addParam("reportManTel" , reportManTel , ParamPosition.QUERY , false);
        request.addParam("reportMan" , reportMan , ParamPosition.QUERY , false);
        request.addParam("soundUrls" , soundUrls , ParamPosition.QUERY , false);
        request.addParam("shopCode" , shopCode , ParamPosition.QUERY , false);
        request.addParam("photographUrls" , photographUrls , ParamPosition.QUERY , false);
        request.addParam("idToken" , idToken , ParamPosition.QUERY , true);
        request.addParam("soundLength" , soundLength , ParamPosition.QUERY , false);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse myApiToken(String userName , String passWord) {
        String path = "/service/loginIn";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("userName" , userName , ParamPosition.QUERY , true);
        request.addParam("password" , passWord , ParamPosition.QUERY , true);


        return sendSyncRequest(request);
    }

    public void UAT_获取授权API(String userName , String password , ApiCallback callback) {
        String path = "/service/loginIn";
        ApiRequest request = new ApiRequest(HttpMethod.GET , path);
        request.addParam("userName" , userName , ParamPosition.QUERY , true);
        request.addParam("password" , password , ParamPosition.QUERY , true);



        sendAsyncRequest(request , callback);
    }
}