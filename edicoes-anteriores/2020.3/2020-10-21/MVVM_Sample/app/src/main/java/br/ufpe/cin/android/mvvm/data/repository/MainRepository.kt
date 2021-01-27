package br.ufpe.cin.android.mvvm.data.repository

import br.ufpe.cin.android.mvvm.data.api.ApiHelper
import br.ufpe.cin.android.mvvm.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {
    fun getUsers() : Single<List<User>> {
        return apiHelper.getUsers()
    }
}