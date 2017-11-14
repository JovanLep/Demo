package com.lep.demo.retrofit;

import com.lep.demo.bean.BannerDate;
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
 *  http://uhome.haier.net:7500/emuplus/secuag/advert/1000/getAdvertInfo
 */

public interface BannerService {

    @GET("/emuplus/secuag/advert/1000/getAdvertInfo")
    Observable<BannerDate> getBanner();

    @GET("getAdvertInfo")
    Call<BannerEntity> getBannerEntity();

    @FormUrlEncoded
    @POST("top250")
    Observable<BannerEntity> getDouBanBannerEntity(@Field("start") int sta,@Field("count")int count);

}
