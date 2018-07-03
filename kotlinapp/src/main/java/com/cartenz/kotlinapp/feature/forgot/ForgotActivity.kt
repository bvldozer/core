package com.cartenz.kotlinapp.feature.forgot

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.cartenz.kotlinapp.R
import com.cartenz.kotlinapp.feature.base.BaseActivity
import kotlinx.android.synthetic.main.forget_pass_activity.*

class ForgotActivity : BaseActivity(), ForgotContract.View {

    private var forgotPresenter: ForgotPresenter? = null
    private var progressDialog: ProgressDialog? = null

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, ForgotActivity::class.java)
            context.startActivity(intent)
        }
    }

    protected override fun getLayoutId(): Int {
        return R.layout.forget_pass_activity
    }

    protected override fun initCreate() {
        forgotPresenter = ForgotPresenter()
        forgotPresenter!!.setView(this, this)

        btn_submit.setOnClickListener {
            if (!TextUtils.isEmpty(et_email!!.text)) {
                if (Patterns.EMAIL_ADDRESS.matcher(et_email!!.text).matches()) {
                    et_email!!.error = null
                    progressDialog = ProgressDialog.show(this, "", "")
                    forgotPresenter!!.callForgot(et_email!!.text.toString())
                }
            }
        }

    }

    protected override fun initDestroy() {
        forgotPresenter!!.dropView()
    }

    override fun forgotResult(error: String) {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
            if (TextUtils.isEmpty(error)) {
                Toast.makeText(this, "sukses", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Gagal , $error", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
