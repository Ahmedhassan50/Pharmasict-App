package com.example.pharmasictapp.db

object LoggingUserInfo {
    private var emailAddress: String? = null
    private var id: String? = null
    private var phoneNumber: String? = null
    private var token: String? = null
    private var name: String? = null

    fun setToken(token: String) {
        this.token = token
    }

    fun setPhoneNumber(phoneNumber: String) {
        this.phoneNumber = phoneNumber
    }

    fun setId(id: String) {
        this.id = id
    }

    fun setEmailAddress(email: String) {
        emailAddress = email
    }

    fun setName(name: String) {
        this.name = name
    }


    fun getEmailAddress(): String {
        return emailAddress ?: "gust@gmail.com"
    }

    fun getName(): String {
        return name ?: "Gust"
    }

    fun getId(): String? {
        return id
    }

    fun phoneNumber(): String? {
        return phoneNumber
    }

    fun phoneToken(): String? {
        return token
    }

}