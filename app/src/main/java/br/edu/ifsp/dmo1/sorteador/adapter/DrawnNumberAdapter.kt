package br.edu.ifsp.dmo1.sorteador.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.edu.ifsp.dmo1.sorteador.R
import br.edu.ifsp.dmo1.sorteador.model.DrawnNumber

class DrawnNumberAdapter(context: Context, private val drawnNumbers: List<DrawnNumber>) :
    ArrayAdapter<DrawnNumber>(context, 0, drawnNumbers) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.item_draw_number, parent, false
        )

        val drawnNumber = drawnNumbers[position]
        val orderTextView: TextView = view.findViewById(R.id.drawn_order)
        val numberTextView: TextView = view.findViewById(R.id.drawn_number)

        orderTextView.text = "${drawnNumber.order}º sorteado = "
        numberTextView.text = drawnNumber.number.toString()

        return view
    }
}