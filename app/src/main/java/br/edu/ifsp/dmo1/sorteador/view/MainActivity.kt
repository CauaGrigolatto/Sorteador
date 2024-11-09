package br.edu.ifsp.dmo1.sorteador.view

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.dmo1.sorteador.R
import br.edu.ifsp.dmo1.sorteador.databinding.ActivityMainBinding
import br.edu.ifsp.dmo1.sorteador.model.Draw

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding:ActivityMainBinding
    private var draw = Draw()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListener()
    }

    override fun onClick(v: View) {
        when(v) {
            binding.buttonUseLimit -> {
                val limit: Int = try {
                    binding.editMaxLimit.text.toString().toInt()
                }
                catch(e: NumberFormatException) {
                    -1
                }

                draw = if (limit > 1) {
                    Draw(1,limit)
                }
                else {
                    Draw()
                }

                updateUI()
            }

            binding.buttonDraw -> {
                binding.textViewExit.text = draw.getNumber().toString()
                updateListView()
            }
        }
    }

    private fun setClickListener() {
        binding.buttonDraw.setOnClickListener(this)
        binding.buttonUseLimit.setOnClickListener(this)
    }

    private fun updateUI() {
        val str = String.format("Intervalo de 1 à %,d.", draw.getMaxLimit())
        binding.textViewInterval.text = str
        binding.editMaxLimit.text.clear()
        binding.textViewExit.text = getString(R.string.start_draw)
        updateListView()
    }

    private fun updateListView() {
        val adapter: ArrayAdapter<Int> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            draw.getHistory()
        )

        binding.listViewDraw.adapter = adapter
    }
}