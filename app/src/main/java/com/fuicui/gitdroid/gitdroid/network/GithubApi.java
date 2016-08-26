package com.fuicui.gitdroid.gitdroid.network;

import com.fuicui.gitdroid.gitdroid.login.User;
import com.fuicui.gitdroid.gitdroid.login.model.AccessToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 放置接口请求API
 * 作者：yuanchao on 2016/8/26 0026 09:40
 * 邮箱：yuanchao@feicuiedu.com
 */
public interface GithubApi {

    //Github开发者，申请的信息
    String CLIENT_ID="b3e74e2bfb623295d629";
    String CLIENT_SECRET="553af778b07f66221efc8225e7c20491f88c3169";

    //申请时填写的标志（重定向标记）
    String CALL_BACK="feicui";

    //授权登陆时可访问域
    String AUTH_SCOPE="user,public_repo,repo";

    //登录页面的网址(WebView来进行访问)
    String AUTH_URL = "https://github.com/login/oauth/authorize?client_id="+CLIENT_ID+"&scope="+AUTH_SCOPE;

    /**
     * 获得访问令牌Token
     * @return
     */
    @FormUrlEncoded
    @POST("https://github.com/login/oauth/access_token")
    @Headers("Accept: application/json")
    Call<AccessToken> getOAuthToken(
            @Field("client_id") String clientId,
            @Field("client_secret")String clientSecret,
            @Field("code") String code);

    /**
     * 使用Token获取用户信息
     * @return
     */
    @GET("user")
    Call<User> getUser();

}
