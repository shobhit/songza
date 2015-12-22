package com.localhost.shobhitjain.songza;

import java.util.ArrayList;
import java.util.List;

import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.Url;
import rx.Observable;

/**
 * Created by shobhitjain on 16/12/15.
 */
public interface SongInterface {
    @GET
    Observable<List<Song>> fetchSongList(@Url String url);

    static final String BASE_URL = "http://api.egghd.com/music_search.php?key=uhrbgihdrfbsbdugysdfhdfuhdfvdfhvrf&&q=shaan";

    class Factory {
        public static SongInterface create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(SongInterface.class);
        }
    }
}
