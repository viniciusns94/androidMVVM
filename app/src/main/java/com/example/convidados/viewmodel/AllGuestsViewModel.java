package com.example.convidados.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.convidados.model.FeedBack;
import com.example.convidados.model.GuestModel;
import com.example.convidados.repository.GuestRepository;

import java.util.List;

public class AllGuestsViewModel extends AndroidViewModel {

    private GuestRepository mRepository;

    private MutableLiveData<List<GuestModel>> mGuestList = new MutableLiveData<>();
    public LiveData<List<GuestModel>> guestList = this.mGuestList;

    private MutableLiveData<FeedBack> mFeedBack = new MutableLiveData<>();
    public LiveData<FeedBack> feedBack = this.mFeedBack;

    public AllGuestsViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = GuestRepository.getInstance(application.getApplicationContext());
    }

    public void getList() {
        this.mGuestList.setValue(this.mRepository.getList());
    }

    public void delete(int id) {
        if (this.mRepository.delete(id)) {
            this.mFeedBack.setValue(new FeedBack("Convidado removido com sucesso"));
        } else {
            this.mFeedBack.setValue(new FeedBack("Erro inesperado", false));
        }
    }
}