package greencode.ir.cbr.base;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import greencode.ir.cbr.R;
import greencode.ir.cbr.application.CBRApplication;
import greencode.ir.cbr.di.component.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity{
    Dialog waitingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initialDialog();
        onViewReady(savedInstanceState,getIntent());
    }
    @CallSuper
    public void onViewReady(Bundle savedInstanceState, Intent intent) {
        resolveDaggerDependency();
    }
    protected void resolveDaggerDependency() {
    }
    protected ApplicationComponent getApplicationComponent(){
        CBRApplication app =
                (CBRApplication) getApplication();
        return app.getApplicationComponent();
    }
    private void initialDialog() {
        waitingDialog = new Dialog(this);
        waitingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        waitingDialog.getWindow().setBackgroundDrawableResource(R.drawable.bgx_dialog);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(waitingDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        waitingDialog.getWindow().setAttributes(lp);
        waitingDialog.setContentView(R.layout.dialog_waite);
        waitingDialog.setCancelable(false);
    }
    public void showWaitingDialog(boolean show) {
        if (waitingDialog != null)
            if (show)
                waitingDialog.show();
            else if (waitingDialog.isShowing())
                waitingDialog.dismiss();
    }
    protected abstract int getContentView();
}
