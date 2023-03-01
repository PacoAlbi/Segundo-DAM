package com.example.examenfinalpruebaandroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenfinalpruebaandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var urls: MutableList<UrlEntity>
    lateinit var adapter: UrlAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        urls = ArrayList()
        getUrls()
        binding.btnAddUrl.setOnClickListener{
            addMultimedia(UrlEntity(name = binding.etUrl.text.toString()))

        }

    }


    private fun getUrls() = runBlocking {
        launch {
            urls = ReproductorApp.database.urlDao().getAll()
            setUpRecyclerView(urls)
            Log.d("Pruebas", urls.toString())
        }

    }

    private fun setUpRecyclerView(urls: MutableList<UrlEntity>) {
        adapter = UrlAdapter(urls, { clickListener(it)}, {deleteMultimedia(it) } )
        recyclerView = binding.rvUrl
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


    private fun clickListener(it: UrlEntity) {
        mediaPlayer = MediaPlayer.create(this, R.raw.snd_boton)
        mediaPlayer.start()
        val intent = Intent(this, ReproductorActivity::class.java)
            .putExtra("url", it.name)
        startActivity(intent)
        finish()
    }

    private fun clearFocus() {
        binding.etUrl.setText("");
    }


    fun Context.hideKeyboard() {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }


    private fun addMultimedia(url: UrlEntity) = runBlocking {
        launch {
            val id = ReproductorApp.database.urlDao().addUrl(url)
            val recoveryUrl = ReproductorApp.database.urlDao().getUrlById(id)
            urls.add(recoveryUrl)
            adapter.notifyItemInserted(urls.size)

            Log.d("Pruebas", id.toString())
            clearFocus()
            hideKeyboard()
        }

    }
    private fun deleteMultimedia(url: UrlEntity) = runBlocking {
        launch {
            ReproductorApp.database.urlDao().deleteUrl(url)
            urls.remove(url)
            adapter.notifyItemRemoved(urls.indexOf(url))
        }
    }
}