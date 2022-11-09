package com.example.universitasbaiklaku086

import android.content.*
import android.graphics.Color
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.*

class AdapterProdi(val listProdi: ArrayList<Prodi>, val mode: String, val context: Context):
    RecyclerView.Adapter<AdapterProdi.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = if (mode == "List") R.layout.layout_prodi_row else R.layout.layout_prodi_grid
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lp = listProdi[position]
        val warna = Color.parseColor(lp.warna)
        val jenjang = lp.jenjang
        val nmProdi = lp.nmProdi
        val fakultas = lp.fakultas
        var konsentrasi = ""
        for (i in lp.konsentrasi.indices) {
            konsentrasi += "${i + 1}. "
            konsentrasi += "${lp.konsentrasi[i]}\n"
        }
        val warnaDec = lp.warna.substring(1..6).toInt(16)
        val urlGambar = when (jenjang) {
            "D3" -> "https://go.stp-bandung.ac.id/images/logo/3dbookmarkD3.png"
            "S1" -> "https://go.stp-bandung.ac.id/images/logo/3dbookmarkS1.png"
            else -> "https://go.stp-bandung.ac.id/images/logo/3dbookmarks2.png"
        }
        with(holder) {
            cvProdi.setCardBackgroundColor(warna)
            tvNmProdi.text = nmProdi
            tvNmProdi.setTextColor(if (warnaDec >= 8_388_608) Color.BLACK else Color.WHITE)
            tvFakultas.text = fakultas
            tvFakultas.setTextColor(if (warnaDec >= 8_388_608) Color.BLACK else Color.WHITE)
            if (mode == "List")
                Picasso.get().load(urlGambar).fit().into(imgJenjang)
            else
                Picasso.get().load(urlGambar).resize(100, 100).into (imgJenjang)
            itemView.setOnClickListener {
                val alb = AlertDialog.Builder(context)
                with(alb) {
                    setCancelable(true)
                    setTitle("Konsentrasi Program Studi $nmProdi ($jenjang)")
                    setMessage(konsentrasi.trim())
                    create().show()
                }
            }
        }
    }

    override fun getItemCount() = listProdi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cvProdi = itemView. findViewById<CardView>(R.id.cvProdi)
        val imgJenjang = itemView. findViewById<ImageView>(R.id.imgJenjang)
        val tvNmProdi = itemView. findViewById<TextView>(R.id.tvNmProdi)
        val tvFakultas = itemView. findViewById<TextView>(R.id.tvFakultas)
    }
}