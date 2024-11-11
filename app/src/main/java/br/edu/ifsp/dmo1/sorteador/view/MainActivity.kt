package br.edu.ifsp.dmo1.sorteador.view

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.dmo1.sorteador.R
import br.edu.ifsp.dmo1.sorteador.adapter.DrawnNumberAdapter
import br.edu.ifsp.dmo1.sorteador.databinding.ActivityMainBinding
import br.edu.ifsp.dmo1.sorteador.model.Draw

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listView: ListView
    private lateinit var adapter: DrawnNumberAdapter
    private var draw = Draw()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListener()
        setListViewAndAdapter()
    }

    override fun onClick(v: View) {
        when(v) {
            binding.buttonUseLimit -> {
                val limit: Int = try {
                    binding.editMaxLimit.text.toString().toInt()
                }
                catch(e: NumberFormatException) {
                    1000
                }

                if (limit > 1) {
                    draw = Draw(limit)
                }

                updateUI()
            }

            binding.buttonDraw -> {
                if (! draw.isFull()) {
                    binding.textViewLastDrawn.text = draw.getNumber().toString()
                    updateListView()
                }
                else {
                    Toast.makeText(
                        this,
                        "Quantidade máxima de números sorteados.",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setClickListener() {
        binding.buttonDraw.setOnClickListener(this)
        binding.buttonUseLimit.setOnClickListener(this)
    }

    private fun updateUI() {
        val str = "Intervalo de 1 à ${draw.getMaxLimit()}"
        binding.textViewInterval.text = str
        binding.editMaxLimit.text.clear()
        binding.textViewLastDrawn.text = getString(R.string.start_draw)
        updateListView()
    }

    private fun updateListView() {
        adapter.clear()
        adapter.addAll(draw.getHistory().sortedBy { it.order })
        adapter.notifyDataSetChanged()
    }

    private fun setListViewAndAdapter() {
        listView = binding.listViewDraw
        adapter = DrawnNumberAdapter(this, draw.getHistory())
        listView.adapter = adapter
    }
}