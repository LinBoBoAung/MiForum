package com.padcmyanmar.miforum.Events

import android.provider.SyncStateContract
import com.padcmyanmar.miforum.Data.HealthCareInfoVO
import com.padcmyanmar.miforum.Utils.Constants

class DataEvent {

    class HealthCareLoadedEvent(val loadHealthEventInfo: List<HealthCareInfoVO>)
    class EmptyDataLoadEvent(val errorMsg: String? = Constants.EMPTY_BODY_RESPONSE)
}