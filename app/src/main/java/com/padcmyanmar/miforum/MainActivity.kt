package com.padcmyanmar.miforum

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.padcmyanmar.miforum.Adapters.ForumAdapter
import com.padcmyanmar.miforum.Data.HealthCareInfoVO
import com.padcmyanmar.miforum.Data.Models.HealthCareModel
import com.padcmyanmar.miforum.Delegate.HealthCareDelegate
import com.padcmyanmar.miforum.Events.DataEvent
import com.padcmyanmar.miforum.Events.ErrorEvent
import com.padcmyanmar.mmnews.kotlin.components.SmartScrollListener


import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity(), HealthCareDelegate {
    override fun onTabHealthCare(healthCare: HealthCareInfoVO?) {

    }


    private var mForumAdapter: ForumAdapter? = null
    private var mSmartScrollListener: SmartScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_feed.layoutManager = LinearLayoutManager(applicationContext)

//        mSmartScrollListener = SmartScrollListener(object : SmartScrollListener.OnSmartScrollListener {
//            override fun onListEndReach() {
//                Snackbar.make(rv_feed, "Loading more data.", Snackbar.LENGTH_LONG).show()
////                SwipeRefreshLayout.isRefreshing = true
//                HealthCareModel.getInstance().loadHealthCareInfo()
   //         }
    //    })

  //      rv_feed.addOnScrollListener(mSmartScrollListener)

        mForumAdapter = ForumAdapter(applicationContext, this)
        rv_feed.adapter = mForumAdapter
      //  SwipeRefreshLayout.isRefreshing = true
        HealthCareModel.getInstance().loadHealthCareInfo()

//
//        SwipeRefreshLayout.setOnRefreshListener {
//
//
//            val mHealthCareAdapter = mForumAdapter
//            mHealthCareAdapter!!.clearData()
//            HealthCareModel.getInstance().loadHealthCareInfo()
//        }//TODO try to clean after testing
//
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorNewsLoadedEvent(mApiErrorEvent: ErrorEvent.ApiErrorEvent) {
        SwipeRefreshLayout.isRefreshing = false
        Snackbar.make(rv_feed, "ERROR" + mApiErrorEvent.getMsg(), Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show()
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEmptyNewsLoadedEvent(emptyDataLoadedEvent: DataEvent.EmptyDataLoadEvent) {
        SwipeRefreshLayout.isRefreshing = false
        Snackbar.make(rv_feed, "Empty Data: " + emptyDataLoadedEvent.errorMsg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }


}



