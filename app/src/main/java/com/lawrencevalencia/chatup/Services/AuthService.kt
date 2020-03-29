package com.lawrencevalencia.chatup.Services

import android.content.Context
import android.util.Log
import org.json.JSONObject
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.lawrencevalencia.chatup.Utilities.URL_REGISTER

object AuthService {

    //Register User Request
    fun registerUser(context: Context, email:String, password:String, complete:(Boolean)->Unit){
        //create request
        val jsonBody = JSONObject()
        jsonBody.put("email",email)
        jsonBody.put("password",password)
        val requestBody = jsonBody.toString()

        val registerRequest = object:StringRequest(Method.POST, URL_REGISTER,
            Response.Listener { response -> println(response)  },
            Response.ErrorListener { error -> Log.d("ERROR",
                "Could not register user: $error") }) {

            //build header records
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }
            override fun getBody(): ByteArray {
                return requestBody.toByteArray()
            }
        }
        //send request
        Volley.newRequestQueue(context).add(registerRequest)
    }
}