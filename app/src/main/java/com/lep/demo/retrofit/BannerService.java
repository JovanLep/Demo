package com.lep.demo.retrofit;

import com.lep.demo.bean.BannerEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by android on 2017/10/27.
 *  apiService
 */

public interface BannerService {

    @GET("latest")
    Call<BannerEntity> getBannerEntity();

    @GET("latest")
    Observable<BannerEntity> getBannerEntity2();

    @FormUrlEncoded
    @POST("top250")
    Observable<BannerEntity> getDouBanBannerEntity(@Field("start") int sta,@Field("count")int count);

}
