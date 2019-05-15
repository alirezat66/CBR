package greencode.ir.cbr.ui.login;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import greencode.ir.cbr.R;
import greencode.ir.cbr.base.BaseActivity;
import greencode.ir.cbr.di.component.DaggerLoginComponent;
import greencode.ir.cbr.di.madoul.MyLoginModule;
import greencode.ir.cbr.mvp.model.LoginResponse;
import greencode.ir.cbr.mvp.view.LoginView;

public class LoginActivity extends BaseActivity implements LoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        ButterKnife.bind(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }


    @Override
    protected void resolveDaggerDependency() {
        DaggerLoginComponent.builder().applicationComponent(getApplicationComponent())
                .myLoginModule(new MyLoginModule(this))
                .build().inject(this);
        super.resolveDaggerDependency();
    }

    @Override
    public void onLoginFinished(LoginResponse response) {

    }

    @Override
    public void onHideDialog() {

    }

    @Override
    public void onShowDialog() {

    }

    @Override
    public void onClearItem() {

    }
}
