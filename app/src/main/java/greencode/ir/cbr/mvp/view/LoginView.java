package greencode.ir.cbr.mvp.view;

import greencode.ir.cbr.base.BaseView;
import greencode.ir.cbr.mvp.model.LoginResponse;


public interface LoginView extends BaseView {
    void onLoginFinished(LoginResponse response);
    void onHideDialog();
    void onShowDialog();
    void onClearItem();
}
