package yzl.swu.caculatoractivities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //初始化下拉列表
        ArrayAdapter(this, android.R.layout.simple_spinner_item,resources.getStringArray(R.array.spinnerarray)).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }.also {
            ctype!!.adapter = it
        }


        //计算
        toResultBtn.setOnClickListener{
            //跳转到计算页面
            Intent(this,CaculateActivity::class.java).apply {
                CaculatorModel().apply {
                    param1 = Integer.parseInt(editTextNumber.editableText.toString())
                    caculatortype = ctype.selectedItem.toString()
                    param2 = Integer.parseInt(editTextNumber2.editableText.toString())
                }.also {
                    this.putExtra("cacuModel",it)
                }
            }.also {
                startActivityForResult(it,1)
            }
        }

        //分享
        shareBtn.setOnClickListener{
            Intent().apply {
                action = "yzl.action.shareToWechat"
                data = Uri.parse("yzl:小朋友哈哈哈哈哈哈哈哈哈，你是不是沙雕，分享到微信10086")
            }.also {
                startActivityForResult(it,9)
            }
        }


    }

    @SuppressLint("WrongConstant")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            1 -> if (resultCode == 1){
                    if (data != null) {
                        //resultTextView.setText()
                        resultTextView.text=data.getIntExtra("result",0).toString()
                    }
                }
            9 -> if (resultCode == 1){
                if (data != null) {
                    //resultTextView.setText()

                    Toast.makeText(this,data.getStringExtra("sharedResult"),1000).show()
                }
            }
        }
    }
}