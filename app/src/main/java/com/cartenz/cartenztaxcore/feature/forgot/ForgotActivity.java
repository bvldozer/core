package com.cartenz.cartenztaxcore.feature.forgot;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import com.cartenz.cartenztaxcore.R;
import com.cartenz.cartenztaxcore.feature.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgotActivity extends BaseActivity implements ForgotContract.View {

    @BindView(R.id.et_email)
    EditText etEmail;
    private ForgotPresenter forgotPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.forget_pass_activity;
    }

    @Override
    protected void initCreate() {
        forgotPresenter = new ForgotPresenter();
        forgotPresenter.setView(this, this);

    }

    @Override
    protected void initDestroy() {
        forgotPresenter.dropView();
    }

    public static void startThisActivity(Context context) {
        Intent intent = new Intent(context, ForgotActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void forgotResult(String error) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            if (TextUtils.isEmpty(error)) {
                Toast.makeText(this, "sukses", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Gagal , " + error, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick(R.id.btn_submit)
    public void onViewClicked() {
        if (!TextUtils.isEmpty(etEmail.getText())) {
            if (Patterns.EMAIL_ADDRESS.matcher(etEmail.getText()).matches()) {
                etEmail.setError(null);
                progressDialog = ProgressDialog.show(this, "", "");
                forgotPresenter.callForgot(etEmail.getText().toString());
            }
        }
    }


}
