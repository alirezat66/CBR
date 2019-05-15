package greencode.ir.cbr.di.component;

import dagger.Component;
import greencode.ir.cbr.ui.login.LoginActivity;
import greencode.ir.cbr.di.madoul.MyLoginModule;
import greencode.ir.cbr.di.scope.PerActivity;


@PerActivity
@Component(modules = MyLoginModule.class,dependencies = ApplicationComponent.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
