package greencode.ir.cbr.mvp.presenter;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import greencode.ir.cbr.api.CBRApiService;
import greencode.ir.cbr.base.BasePresenter;
import greencode.ir.cbr.mvp.model.LoginResponse;
import greencode.ir.cbr.mvp.view.LoginView;
import static io.reactivex.internal.operators.observable.ObservableBlockingSubscribe.subscribe;

public class LoginPresenter extends BasePresenter<LoginView> implements Observer<LoginResponse>{
    @Inject protected CBRApiService mApiService;
   /* @Inject protected CakeMapper cakeMapper;
    @Inject protected Storage mStorage;*/
    @Inject
    public LoginPresenter(){

    }
    public void getCakes() {
        getView().onShowDialog();
        Observable<LoginResponse> cakeResponseObservable = mApiService.getCakes();
        subscribe(cakeResponseObservable,this);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(LoginResponse response) {


        getView().onClearItem();
        getView().onLoginFinished(response);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        getView().onHideDialog();
    }

    /*public void getCakesFromDataBase() {
        List<Cake> cakeList = mStorage.getSavedCakes();


    }*/
}
