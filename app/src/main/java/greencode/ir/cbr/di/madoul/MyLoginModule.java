package greencode.ir.cbr.di.madoul;

import dagger.Module;
import dagger.Provides;
import greencode.ir.cbr.api.CBRApiService;
import greencode.ir.cbr.di.scope.PerActivity;
import greencode.ir.cbr.mvp.view.LoginView;

import retrofit2.Retrofit;

@Module
public class MyLoginModule {
    LoginView mView;

    public MyLoginModule(LoginView mView) {
        this.mView = mView;
    }
    @PerActivity
    @Provides
    CBRApiService provideCBRApiService(Retrofit retrofit){
        return retrofit.create(CBRApiService.class);
    }
    @PerActivity
    @Provides
    LoginView provideLoginView(){return mView;}
}
