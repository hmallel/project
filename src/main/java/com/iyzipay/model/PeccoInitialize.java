package com.iyzipay.model;

import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePeccoInitializeRequest;

public class PeccoInitialize extends IyzipayResource {

    private String htmlContent;
    private String redirectUrl;
    private String token;
    private Long tokenExpireTime;

    public static PeccoInitialize create(CreatePeccoInitializeRequest request, Options options) {
        PeccoInitialize response = HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/pecco/initialize",
                getHttpHeaders(request, options),
                request,
                PeccoInitialize.class)
                .getBody();
        if (response != null) {
            response.setHtmlContent(DigestHelper.decodeString(response.getHtmlContent()));
        }
        return response;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTokenExpireTime() {
        return tokenExpireTime;
    }

    public void setTokenExpireTime(Long tokenExpireTime) {
        this.tokenExpireTime = tokenExpireTime;
    }
}
