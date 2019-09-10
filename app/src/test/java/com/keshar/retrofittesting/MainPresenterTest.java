package com.keshar.retrofittesting;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainPresenterTest {
    @Mock
    private CharactersDataSource charactersDataSource;

    @Mock
    private MainContract.View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fetchValidDataShouldLoadIntoView() {

        CharecterResponseModel charecterResponseModel = new CharecterResponseModel(0, null, null, null);
        when(charactersDataSource.getCharacters())
                .thenReturn(Observable.just(charecterResponseModel));
        MainPresenter mainPresenter = new MainPresenter(
                this.charactersDataSource,
                Schedulers.immediate(),
                Schedulers.immediate(),
                this.view
        );
        mainPresenter.loadData();

        InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view, times(1)).onFetchDataStarted();
        inOrder.verify(view, times(1)).onFetchDataSuccess(charecterResponseModel);
        inOrder.verify(view, times(1)).onFetchDataCompleted();
    }

    @Test
    public void fetchErrorShouldReturnErrorToView() {
        Exception exception = new Exception();
        when(charactersDataSource.getCharacters())
                .thenReturn(Observable.<CharecterResponseModel>error(exception));

        MainPresenter mainPresenter = new MainPresenter(
                this.charactersDataSource,
                Schedulers.immediate(),
                Schedulers.immediate(),
                this.view
        );
        mainPresenter.loadData();
        InOrder inOrder = Mockito.inOrder(view);
        inOrder.verify(view, times(1)).onFetchDataStarted();
        inOrder.verify(view, times(1)).onFetchDataError(exception);
        verify(view, never()).onFetchDataCompleted();
    }
}
