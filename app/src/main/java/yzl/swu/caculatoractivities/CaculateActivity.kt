package yzl.swu.caculatoractivities

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_caculate.*

class CaculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caculate)


        //自己计算被点击
        resultBtn.setOnClickListener{
            (intent.getSerializableExtra("cacuModel") as CaculatorModel).apply {
                setResult(1,Intent().putExtra("result",caculator(this)))
            }
            finish()
        }

        //去拍照
        cameraBtn.setOnClickListener{
            Intent().apply {
                action = "android.media.action.IMAGE_CAPTURE"

            }.also {
                startActivity(it)
            }
        }
    }


    //计算功能
    fun caculator(model:CaculatorModel):Int{
        return (when(model.caculatortype){
            "+" -> model.param1+model.param2
            "-" -> model.param1-model.param2
            "*" -> model.param1*model.param2
            "/" -> model.param1/model.param2
            else -> 0
        })
    }
}