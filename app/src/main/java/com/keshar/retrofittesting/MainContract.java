package com.keshar.retrofittesting;

public interface MainContract {

    interface View {

        void onFetchDataStarted();

        void onFetchDataCompleted();

        void onFetchDataSuccess(CharecterResponseModel charactersResponseModel);

        void onFetchDataError(Throwable e);
    }

    interface Presenter {

        void loadData();

        void subscribe();

        void unsubscribe();

        void onDestroy();

    }
}