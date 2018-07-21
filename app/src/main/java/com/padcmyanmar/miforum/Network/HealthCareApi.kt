package com.padcmyanmar.miforum.Network

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface HealthCareApi {
    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun loadHeathCareInfo(
            @Field("access_token") accessToken: String) : Call<GetHealthResponse>

}
