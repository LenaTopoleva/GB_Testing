package com.lenatopoleva.gb_testing.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView: MvpView {
    fun viewOk()
    fun viewEmailsNotEqual()
    fun viewInvalidEmail()
    fun viewInvalidName()
}

