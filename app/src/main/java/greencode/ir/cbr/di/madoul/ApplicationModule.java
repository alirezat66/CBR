package greencode.ir.cbr.di.madoul;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {
    private String baseUrl;
    private Context context;

    public ApplicationModule(String baseUrl, Context context) {
        this.baseUrl = baseUrl;
        this.context = context;
    }
    @Singleton
    @Provides
    Context provideContext(){return context;}

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory(){return GsonConverterFactory.create();}

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .callTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory provideRxCallFactory(){return RxJava2CallAdapterFactory.create();}

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client,GsonConverterFactory converterFactory,RxJava2CallAdapterFactory adapterFactory){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(client)
                .build();
        return retrofit;
    }
}
