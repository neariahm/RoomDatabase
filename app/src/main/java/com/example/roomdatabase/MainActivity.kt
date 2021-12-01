package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import coil.load

class MainActivity : AppCompatActivity() {

  val viewModel : DogViewModel by viewModels()

      override fun onCreate(savedInstanceState: Bundle?)
      { super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
          viewModel.currentlyDisplayedDogPhoto.observe(this,
              { findViewById<ImageView>(R.id.imageView).load(
                  it?.message?.toUri()?.buildUpon()?.scheme("https")?.build()
              ) })
          findViewById<TextView>(R.id.textView2).setOnClickListener { viewModel.getNewPhoto()
          }

      }
}
