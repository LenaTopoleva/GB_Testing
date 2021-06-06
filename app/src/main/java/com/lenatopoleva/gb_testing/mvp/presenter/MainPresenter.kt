package com.lenatopoleva.gb_testing.mvp.presenter

import com.lenatopoleva.gb_testing.mvp.model.User
import com.lenatopoleva.gb_testing.mvp.view.MainView
import moxy.MvpPresenter
import java.util.regex.Pattern

class MainPresenter(): MvpPresenter<MainView>() {

    companion object {
        const val NAME_PATTERN = "^([a-zA-Z]+?)([-\\s'][a-zA-Z]+)*?\$"

    }

    var user: User? = null

    fun saveButtonClicked(emailIsValid: Boolean, email: String?, repeatEmail: String?, name: String?) {
        if (emailIsValid) {
            if (email == repeatEmail) {
                if (nameIsValid(name)) {
                    viewState.viewOk()
                    user = User(name!!, email!!)
                    registrateUser(user);
                }
                else viewState.viewInvalidName()
            }
            else viewState.viewEmailsNotEqual()
        } else {
            viewState.viewInvalidEmail()
        }
    }

    private fun nameIsValid (name: String?): Boolean {
        val pattern = Pattern.compile(NAME_PATTERN)
        return name != null && pattern.matcher(name).matches()
    }

    private fun registrateUser(user: User?) {
        user?.isRegistrated = true;
    }

}