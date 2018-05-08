package com.example.alexandrareinhart.retrofitworkshop;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitMusicApiCalls {

    @GET("{artist}/{title}")
    Call<SongLyrics> getSongLyrics(@Path("artist") String artist, @Path("title") String title);

    class SongLyrics {

        @SerializedName("lyrics")
        private String lyrics;

        public String getLyrics() {
            return lyrics;
        }
    }
}
