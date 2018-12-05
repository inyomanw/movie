package com.inyomanw.moviewdb.ui.base

import android.view.View

interface BaseContract {

    interface Presenter<in v: View>{
        fun onAttach(view: v)
        fun onDetach()
    }
    interface View{
        fun onAttachView()
        fun onDetachView()
    }
}