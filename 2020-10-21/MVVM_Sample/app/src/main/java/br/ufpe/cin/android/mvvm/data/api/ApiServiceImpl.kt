package br.ufpe.cin.android.mvvm.data.api

import br.ufpe.cin.android.mvvm.data.model.User
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl : ApiService {
    override fun getUsers(): Single<List<User>> {
        return Rx2AndroidNetworking.get("https://leopoldomt.com/if1001/users.json")
            .build()
            .getObjectListSingle(User::class.java)
    }
}