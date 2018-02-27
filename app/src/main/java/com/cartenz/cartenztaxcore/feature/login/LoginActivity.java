package com.cartenz.cartenztaxcore.feature.login;

import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import com.cartenz.cartenztaxcore.R;
import com.cartenz.cartenztaxcore.feature.base.BaseActivity;
import com.cartenz.core.utils.Dictionary;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {


    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    private LoginPresenter loginPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    protected void initCreate() {
        loginPresenter = new LoginPresenter();
        loginPresenter.setView(this, this);
        Log.wtf("Test_", Dictionary.getValueByKey(this, "92000001") + " " +
                Dictionary.getKeyByValue(this, "status_data") + " " +
                Dictionary.getValueByKey(this, "status_data") + " " +
                Dictionary.getKeyByValue(this, "92000001")
        );
    }

    @Override
    protected void initDestroy() {
        loginPresenter.dropView();
    }

    @Override
    public void loginResult(String error) {

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        boolean isValid = true;
        String error = "Harus Terisi";
        etEmail.setError(null);
        etPassword.setError(null);

        if (TextUtils.isEmpty(etEmail.getText())) {
            etEmail.setError(error);
            isValid = false;
        }
        if (TextUtils.isEmpty(etPassword.getText())) {
            etPassword.setError(error);
            isValid = false;
        }
        if (isValid) {
            loginPresenter.callLogin(etEmail.getText().toString(), etPassword.getText().toString());
        }

    }
}
