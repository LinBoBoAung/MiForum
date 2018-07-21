package com.padcmyanmar.miforum.Network

import com.google.gson.Gson
import com.padcmyanmar.miforum.Events.DataEvent
import com.padcmyanmar.miforum.Events.ErrorEvent
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HealthCareDataAgent
{
    companion object
    {
        private var INSTANCE: HealthCareDataAgent? = null

        fun getInstance(): HealthCareDataAgent
        {
            if (INSTANCE == null)
            {
                INSTANCE = HealthCareDataAgent()
            }
            var i = INSTANCE
            return i!!
        }
    }

    private var healthcareApi: HealthCareApi

    private constructor()
    {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()


        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/mm-healthcare/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        healthcareApi = retrofit.create(HealthCareApi::class.java)
    }

    fun loadHealthCareInfo(accessToken: String)
    {
        val healthCareResponse = healthcareApi.loadHeathCareInfo(accessToken)
        healthCareResponse.enqueue(object : Callback<GetHealthResponse> {
            override fun onFailure(call: Call<GetHealthResponse>?, t: Throwable?)
            {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

            override fun onResponse(call: Call<GetHealthResponse>?, response: Response<GetHealthResponse>?)
            {
                val healthResponse: GetHealthResponse? = response!!.body()
                if (healthResponse != null && healthResponse.isResponseOK())
                {
                    val newsLoadedEvent = DataEvent.HealthCareLoadedEvent(healthResponse.getHealthCareInfoList()!!)
                    EventBus.getDefault().post(newsLoadedEvent)
                } else
                {
                    if (healthResponse != null)
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadEvent(healthResponse.getMessagge()))
                    else
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadEvent())
                }
            }
        })
    }

}