package com.lawrencevalencia.chatup

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    //Initial Default Value
    var userAvatar = "profileDefault"
    var avatarColor = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun generateAvatarClicked (view: View){
        val wRandom = Random()
        val wColor = wRandom.nextInt(2)
        val wAvatar = wRandom.nextInt(28)

        if (wColor == 0) {
            userAvatar = "light$wAvatar" //filename
        }else{
            userAvatar = "dark$wAvatar" //filename
        }
        //get ID and assign to layout variable
        val wResourceID = resources.getIdentifier(userAvatar,"drawable",packageName)
        createUserAvatarImgView.setImageResource(wResourceID)
    }

    fun generateAvatarBGBtnClicked (view: View){
        val wRandom = Random()
        val wRed = wRandom.nextInt(255)
        val wGrn = wRandom.nextInt(255)
        val wBlue = wRandom.nextInt(255)
        //assign color to avatar background
        createUserAvatarImgView.setBackgroundColor(Color.rgb(wRed,wGrn,wBlue))

        val saveRed = wRed.toDouble()/255
        val saveGrn = wGrn.toDouble()/255
        val saveBlue = wBlue.toDouble()/255

        avatarColor = "[$saveRed, $saveGrn, $saveBlue, 1]"
    }

    fun createCreateUserBtnClick (view: View){}
}
