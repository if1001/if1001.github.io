package br.ufpe.cin.android.mvvm.data.api

import br.ufpe.cin.android.mvvm.data.model.User
import io.reactivex.Single

interface ApiService {
    fun getUsers() : Single<List<User>>
}