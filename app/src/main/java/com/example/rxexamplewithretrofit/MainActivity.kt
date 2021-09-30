package com.example.rxexamplewithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    lateinit var person1: RegisterRequestData
    lateinit var person2: RegisterRequestData




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        person1 = RegisterRequestData("Todd", "354227653","111222333","td@yahoo.com" )
        person2 = RegisterRequestData("Alex","123123123", "111222333", "alex@gmail.com")


        val observable1 = ApiClient.apiService.register(person1)
        val observable2 = ApiClient.apiService.register(person2)

        observable2.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(getObserver())

        observable1.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(getObserver())




    }

    fun getObservable():Observable<RegisterRequestData>{
        return Observable.just(person1,person2)

    }

    fun getObserver():Observer<RegisterResponseData>{
            return object :Observer<RegisterResponseData>{
                override fun onSubscribe(d: Disposable) {
                    Log.d("called ","onSubscribe")
                }


                override fun onError(e: Throwable) {
                    Log.d("called ","onError")
                }

                override fun onComplete() {
                    Log.d("called ","onComplete")
                }

                override fun onNext(t: RegisterResponseData) {
                    Log.d("called ","onNext")
                }
            }


    }


}