package com.inyomanw.moviewdb

class UserRepository {

    fun getDataUser(){

    }
}

class ProfilePresenter(){
    val repo = UserRepository()

    fun getDataUser(){
        repo.getDataUser()
    }
}