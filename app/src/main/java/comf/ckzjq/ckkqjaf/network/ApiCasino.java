package comf.ckzjq.ckkqjaf.network;


import comf.ckzjq.ckkqjaf.network.model.CasinoModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCasino {

    @GET("ckkqjaf")
    Call<CasinoModel> check();

}
