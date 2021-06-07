package com.lenatopoleva.gb_testing.mvp.view

import com.lenatopoleva.gb_testing.mvp.model.User
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainView: MvpView {
    fun viewOk(user: User?)
    fun viewEmailsNotEqual()
    fun viewInvalidEmail()
    fun viewInvalidName()
}

