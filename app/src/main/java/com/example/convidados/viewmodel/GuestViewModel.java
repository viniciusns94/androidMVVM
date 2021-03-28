package com.example.convidados.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.convidados.model.GuestModel;
import com.example.convidados.repository.GuestRepository;

public class GuestViewModel extends AndroidViewModel {

    private final GuestRepository mRepository;
    private MutableLiveData<GuestModel> mGuest = new MutableLiveData<>();
    public LiveData<GuestModel> guest = this.mGuest;

    private MutableLiveData<Boolean> mFeedBack = new MutableLiveData<>();
    public LiveData<Boolean> feedBack = this.mFeedBack;

    public GuestViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = GuestRepository.getInstance(application.getApplicationContext());
    }

    public void save(GuestModel guest) {
        if (guest.getId() == 0)
           this.mFeedBack.setValue(this.mRepository.insert(guest));
        else
            this.mFeedBack.setValue(this.mRepository.update(guest));
    }

    public void load(int id) {
        this.mGuest.setValue(this.mRepository.load(id));
    }
}
