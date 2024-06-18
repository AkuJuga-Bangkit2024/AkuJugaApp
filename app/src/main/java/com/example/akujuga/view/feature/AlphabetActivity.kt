package com.example.akujuga.view.feature

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.akujuga.databinding.ActivityAlphabetBinding
import com.example.akujuga.view.ViewModelFactory

class AlphabetActivity : AppCompatActivity() {
    private val viewModel by viewModels<AlphabetViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private lateinit var binding: ActivityAlphabetBinding
    private lateinit var adapter: ItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlphabetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupAdapter()
        setupSearch()
    }

    private fun setupAdapter() {
        adapter = ItemListAdapter()
        binding.listItem.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        binding.listItem.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.listItem.addItemDecoration(itemDecoration)
    }

    private fun setupSearch() {
        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                .setOnEditorActionListener { textView, actionId, event ->
                    searchBar.setText(searchView.text)
                    searchView.hide()
                    Toast.makeText(this@AlphabetActivity, searchView.text, Toast.LENGTH_SHORT).show()
                    false
                }
        }
    }
}