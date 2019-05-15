package greencode.ir.cbr.api;

import io.reactivex.Observable;
import greencode.ir.cbr.mvp.model.LoginResponse;
import retrofit2.http.GET;

public interface CBRApiService {
    @GET("filippella/a728a34822a3bc7add98e477a4057b69/raw/310d712e87941f569074a63fedb675d2b611342a/cakes")
    Observable<LoginResponse> getCakes();


}
