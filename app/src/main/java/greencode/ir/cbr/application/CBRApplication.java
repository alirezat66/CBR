package greencode.ir.cbr.application;

import android.app.Application;

import greencode.ir.cbr.di.component.ApplicationComponent;
import greencode.ir.cbr.di.component.DaggerApplicationComponent;
import greencode.ir.cbr.di.madoul.ApplicationModule;

public class CBRApplication extends Application {
    private ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        initialApplicationComponent();
    }

    private void initialApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule("",this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
