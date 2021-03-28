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

public class GuestViewModel extends AndroidViewModel {

    private final GuestRepository mRepository;
    private MutableLiveData<GuestModel> mGuest = new MutableLiveData<>();
    public LiveData<GuestModel> guest = this.mGuest;

    private MutableLiveData<FeedBack> mFeedBack = new MutableLiveData<>();
    public LiveData<FeedBack> feedBack = this.mFeedBack;

    public GuestViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = GuestRepository.getInstance(application.getApplicationContext());
    }

    public void save(GuestModel guest) {
        if (guest.getName().equals("")) {
            this.mFeedBack.setValue(new FeedBack("Nome obrigatório !", false));
            return;
        }
        if (guest.getId() == 0) {
            if (this.mRepository.insert(guest)) {
                this.mFeedBack.setValue(new FeedBack("Convidado inserido com sucesso !"));
            } else {
                this.mFeedBack.setValue(new FeedBack("Erro inesperado", false));
            }
        } else {
            if (this.mRepository.update(guest)) {
                this.mFeedBack.setValue(new FeedBack("Convidado atualizado com sucesso !"));
            } else {
                this.mFeedBack.setValue(new FeedBack("Erro inesperado", false));
            }
        }
    }

    public void load(int id) {
        this.mGuest.setValue(this.mRepository.load(id));
    }
}
