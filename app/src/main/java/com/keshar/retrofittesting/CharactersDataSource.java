package com.keshar.retrofittesting;


import retrofit2.http.GET;
import rx.Observable;

public interface CharactersDataSource {
        @GET("people/")
        Observable<CharecterResponseModel> getCharacters();

}
