package com.example.animalbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animalbook.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding
    private lateinit var title: TitleFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ライオン
        binding.lionButton.setOnClickListener {
            ////FragmentManagerクラスのインスタンスを取得
            supportFragmentManager.beginTransaction().apply {
                ////subactivity.xmlにある写真を表示させる部分FrameLayout(id:container)にlionfragmentを配置
                replace(R.id.container, LionFragment())
                //今回のフラグメントの処理をバックスタックに追加->端末の戻るボタンが機能する
                addToBackStack(null)
                //フラグメントの操作を確定
                commit()
            }
        }

        //かば
        binding.hippoButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, HippoFragment())
                addToBackStack(null)
                commit()
            }
        }

        //キリン
        binding.giraffeButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, GiraffeFragment())
                addToBackStack(null)
                commit()
            }
        }
        title = TitleFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.titleFrame, title)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        title.setTitle("サブ画面")
    }
}