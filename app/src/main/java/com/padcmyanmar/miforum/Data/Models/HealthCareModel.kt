package com.padcmyanmar.miforum.Data.Models

import com.padcmyanmar.miforum.Data.HealthCareInfoVO
import com.padcmyanmar.miforum.Events.DataEvent
import com.padcmyanmar.miforum.Network.HealthCareDataAgent
import com.padcmyanmar.miforum.Utils.Constants
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HealthCareModel {
    companion object {
        private var INSTANCE: HealthCareModel? = null
        // private lateinit var INSTANCE:HealthCareModel//same
        fun getInstance(): HealthCareModel {
            if (INSTANCE == null) {
                INSTANCE = HealthCareModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private constructor() {
        EventBus.getDefault().register(this)
    }

    private var mHealthCareData: HashMap<Int, HealthCareInfoVO> = HashMap()//Data Respository in Model,persitent Layerထဲ ထညါ့္ဖို့

    fun  loadHealthCareInfo() {
        HealthCareDataAgent.getInstance().loadHealthCareInfo(Constants.ACCESS_TOKEN)
    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onLoadHealthCareEvent(HealthCareLoadedEvent: DataEvent.HealthCareLoadedEvent) {
        for (healthCare: HealthCareInfoVO in HealthCareLoadedEvent.loadHealthEventInfo) {
            mHealthCareData[healthCare.healthCareId] = healthCare
        }

    }
}