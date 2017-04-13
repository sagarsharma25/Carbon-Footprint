package Interfaces;


import Models.Article;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Iron_Man on 04/02/17.
 */

public interface API_Interface {

    String URL_BASE = "https://newsapi.org/v1/";



    @GET("articles?source=national-geographic&sortBy=top&apiKey=6e43b2d3c2234e339a45511581ba6df4")
    Call<Article> getNews();


    class Factory {

        private static API_Interface service;

        public static API_Interface getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(URL_BASE)
                        .build();

                service = retrofit.create(API_Interface.class);
                return service;
            } else {
                return service;
            }
        }
    }


}
