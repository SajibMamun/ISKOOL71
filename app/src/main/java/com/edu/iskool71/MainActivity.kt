package com.edu.iskool71

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import com.edu.iskool71.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.webviewid.loadUrl("https://www.iskool71.com/")
        binding.webviewid.settings.javaScriptEnabled=true


        ///

  binding.webviewid.webViewClient=object : WebViewClient(){

      override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
          super.onPageStarted(view, url, favicon)
      }

      override fun onPageFinished(view: WebView?, url: String?) {
          super.onPageFinished(view, url)
      }
  }


        //

        binding.webviewid.webChromeClient= object : WebChromeClient(){

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)

            }

        }


    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
       if(binding.webviewid.canGoBack())
       {
           binding.webviewid.goBack()
       }
        else
       {
           val builder=AlertDialog.Builder(this)
          // builder.setIcon(R.drawable.ic_launcher_background)
          // builder.setTitle("Are you Sure?")
           builder.setMessage("want to close this application?")
           builder.setPositiveButton("Yes"){_,_ ->
               finish()
           }
           builder.setNegativeButton("No"){ _,_ -> }

           val alertDialog=builder.create()
           alertDialog.show()

       }
    }
}