package com.example.convidados.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.convidados.model.GuestModel;
import com.example.convidados.repository.GuestRepository;

public class GuestViewModel extends ViewModel {

    public void save(GuestModel guest) {
        new GuestRepository().insert(guest);
    }

}
