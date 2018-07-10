package com.cartenz.kotlinapp.feature.login

import android.text.TextUtils
import android.widget.ArrayAdapter
import com.cartenz.kotlinapp.R
import com.cartenz.kotlinapp.feature.base.BaseActvity
import kotlinx.android.synthetic.main.login_activity.*


class LoginActivity : BaseActvity(), LoginContract.ViewCartenz {

    private var loginPresenter: LoginPresenter? = null

    protected override fun getLayoutId(): Int {
        return R.layout.login_activity
    }

    protected override fun initCreate() {
        loginPresenter = LoginPresenter()
        loginPresenter!!.setView(this, this)

        var selectedPosition: Int
        var selectedText: String


        val arrays = arrayOf("test1", "test2")
        val arrayAdapter = ArrayAdapter(
                this, android.R.layout.simple_list_item_1, arrays)
        sp_spinner.setAdapter(arrayAdapter)
//        sp_spinner.setSelectedPosition(1)


        btn_login.setOnClickListener {
            var isValid = true
            val error = "Harus Terisi"
            et_email!!.error = null
            et_password!!.error = null
            sp_spinner!!.error = null

            if (TextUtils.isEmpty(et_email!!.text)) {
                et_email!!.error = error
                isValid = false
            }
            if (TextUtils.isEmpty(et_password!!.text)) {
                et_password!!.error = error
                isValid = false
            }

            if (sp_spinner!!.selectedPosition == -1) {
                sp_spinner!!.error = error
                isValid = false
            }


            if (isValid) {
                loginPresenter!!.callLogin(et_email!!.text.toString(), et_password!!.text.toString())
            }
        }

    }

    protected override fun initDestroy() {
        loginPresenter!!.dropView()
    }

    override fun loginResult(error: String) {

    }

}
