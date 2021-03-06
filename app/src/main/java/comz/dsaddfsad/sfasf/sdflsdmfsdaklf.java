package comz.dsaddfsad.sfasf;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import comz.dsaddfsad.sfasf.dfsasdfsd.NetworkDelegat;
import comz.dsaddfsad.sfasf.dfsasdfsd.model.CasinoModel;
import comz.dsaddfsad.sfasf.slotmania.GameActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class sdflsdmfsdaklf extends Activity {

    public static final String BASE_KEY_URL = "BASE_KEY_URL";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        NetworkDelegat.provideApiModule().check().enqueue(new Callback<CasinoModel>() {
//            @Override
//            public void onResponse(Call<CasinoModel> call, Response<CasinoModel> response) {
//                if (response.isSuccessful()) {
//                    CasinoModel casinoModel = response.body();
//                    if (casinoModel != null) {
//                        if (casinoModel.getResult()) {
//                            configGame(casinoModel.getUrl());
//                        } else {
//                            openGame();
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CasinoModel> call, Throwable t) {
//                openGame();
//            }
//        });
        configGame(BASE_KEY_URL);
    }

    private void configGame(String url) {
        Intent intent = getIntent();
        if (intent != null) {
            String transform = url;
            Uri data = intent.getData();
            if (data != null && data.getEncodedQuery() != null) {
                String QUERY_1 = "cid";
                String QUERY_2 = "partid";
                if (data.getEncodedQuery().contains(QUERY_1)) {
                    String queryValueFirst = data.getQueryParameter(QUERY_1);
                    transform = transform.replace(queryValueFirst, "cid");
                } else if (data.getEncodedQuery().contains(QUERY_2)) {
                    String queryValueSecond = data.getQueryParameter(QUERY_2);
                    transform = transform.replace(queryValueSecond, "partid");
                }
                openWebGame(transform);
            } else {
                openWebGame(transform);
            }

        } else {
            openWebGame(url);
        }
    }


    private void openWebGame(String url) {
        Intent intent = new Intent(this, salfnsmaldf.class);
        intent.putExtra(BASE_KEY_URL, url);
        startActivity(intent);
        finish();
    }


    private void openGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}
