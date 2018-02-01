package comf.ckzjq.ckkqjaf.dfsasdfsd;


import comf.ckzjq.ckkqjaf.dfsasdfsd.model.CasinoModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCasino {

    @GET("ckkqjaf")
    Call<CasinoModel> check();

}
