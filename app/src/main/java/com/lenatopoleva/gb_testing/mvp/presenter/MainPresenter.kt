package com.lenatopoleva.gb_testing.mvp.presenter

import com.lenatopoleva.gb_testing.mvp.model.User
import com.lenatopoleva.gb_testing.mvp.view.MainView
import moxy.MvpPresenter
import java.util.regex.Pattern

class MainPresenter(): MvpPresenter<MainView>() {

    companion object{
        const val NAME_PATTERN = "^([a-zA-Z]+?)([-\\s'][a-zA-Z]+)*?\$"

    }

    private var user: User? = null

    fun saveButtonClicked(emailIsValid: Boolean, email: String?, repeatEmail: String?, name: String?): User? {
        if (emailIsValid) {
            if (emailsAreEqual(email, repeatEmail)) {
                if (isNameValid(name)) {
                    viewState.viewOk()
                    user = User(makeFirstLetterOfNameUppercase(name!!), email!!)
                    registrateUser(user);
                    return user
                }
                else viewState.viewInvalidName()
            }
            else viewState.viewEmailsNotEqual()
        } else {
            viewState.viewInvalidEmail()
        }
        return user
    }

    fun emailsAreEqual(email: String?, repeatEmail: String?): Boolean{
        return email == repeatEmail
    }

    fun isNameValid (name: String?): Boolean {
        val pattern = Pattern.compile(NAME_PATTERN)
        return name != null && pattern.matcher(name).matches()
    }

    fun makeFirstLetterOfNameUppercase(name: String): String {
        return name[0].toUpperCase() + name.substring(1)
    }

    fun registrateUser(user: User?): User? {
        user?.isRegistrated = true;
        return user
    }

}