package com.example.universitasbaiklaku086

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Universitas Baik Laku"

        val grpTampilan = findViewById<RadioGroup>(R.id.grpTampilan)
        val rvProdi = findViewById<RecyclerView>(R.id.rvProdi)

        rvProdi.layoutManager = LinearLayoutManager(this@MainActivity)
        val listProdi = arrayListOf(
            Prodi("#FF7F00", "S1", "Teknik Informatika", "Fakultas Teknologi Informasi", arrayOf(
                "Cyber Security", "Programming Expert", "Artificial Intelligent"
            )),
            Prodi("#0000FF", "S1", "Sistem Informasi", "Fakultas Teknologi Informasi", arrayOf(
                "Sistem Enterprise", "Digitalpreneurship", "Data Science"
            )),
            Prodi("#B2FFFF", "S1", "Sistem Komputer", "Fakultas Teknologi Informasi", arrayOf(
                "Embedded System & Internet of Things", "Robotics"
            )),
            Prodi("#FFFF00", "D3", "Manajemen Informatika", "Fakultas Teknologi Informasi", arrayOf(
                "Mobile Application Development", "Interactive Digital Design", "Network Engineering"
            )),
            Prodi("#4B3621", "D3", "Komputerisasi Akuntansi", "Fakultas Teknologi Informasi",
                arrayOf("Accounting Information System", "Digital Business")),
            Prodi("#000000", "S2", "Ilmu Komputer", "Fakultas Teknologi Informasi", arrayOf(
                "Teknologi Sistem Informasi", "Rekayasa Komputasi Terapan"
            )),
            Prodi("#006B3C", "S1", "Manajemen", "Fakultas Ekonomi dan Bisnis", arrayOf(
                "Corporate Finance and Capital Markets", "Marketing & Digital Business", "Strategic Human Resource Management",
                "International Business Management", "Renewable Energy and Natural Resource Management"
            )),
            Prodi("#FFFF99", "S1", "Akuntasi", "Fakultas Ekonomi dan Bisnis", arrayOf(
                "Managerial Accounting", "Audit Assurance", "Tax Accounting", "Business Analytics",
                "Corporate Governance and CSR"
            )),
            Prodi("#7F1734", "S1", "Manajemen Bencana", "Fakultas Ekonomi dan Bisnis"),
            Prodi("#B03060", "D3", "Sekretari", "Fakultas Ekonomi dan Bisnis"),
            Prodi("#353839", "S2", "Manajemen", "Fakultas Ekonomi dan Bisnis", arrayOf(
                "Marketing Management", "Financial Management", "Human Resource Management", "Management Information Systems",
                "Education Management"
            )),
            Prodi("#32127A", "S2", "Akuntasi", "Fakultas Ekonomi dan Bisnis", arrayOf(
                "Akuntansi Keuangan", "Akuntasi Manajemen", "Audit", "Perpajakan", "Sistem Informasi Akuntasi"
            )),
            Prodi("#01796F", "S1", "Teknik Arsitektur", "Fakultas Teknik", arrayOf(
                "Eco-Smart Real Estate", "Smart Interior"
            )),
            Prodi("#536878", "S1", "Teknik Elektro", "Fakultas Teknik", arrayOf(
                "Telekomunikasi dan Multimedia", "Kontrol dan Otomasi Industri"
            )),
            Prodi("#00FFFF", "S1", "Hubungan Internasional", "Fakultas Ilmu Sosial dan Politik", arrayOf(
                "Ekonomi Politik Internasional", "Diplomasi", "Studi Kawasan"
            )),
            Prodi("#00A86B", "S1", "Kriminologi", "Fakultas Ilmu Sosisal dan Politik", arrayOf(
                "Kriminologi Cyber", "Kriminologi Jurnalistik", "Manajemen Security"
            )),
            Prodi("#F8DE7E", "S1", "Ilmu Komunikasi", "Fakultas Komunikasi dan Desain Kreatif",
                arrayOf("Broadcast Journalism", "Public Relation", "Tourism Communication", "Digital Media & Advertising")),
            Prodi("#727472", "S1", "Desain Komunikasi Visual", "Fakultas Komunikasi dan Desain Kreatif",
                arrayOf("Game Development", "Animation", "Graphic Design")),
            Prodi("#FF0000", "S2", "Ilmu Komunikasi", "Fakultas Komunikasi dan Desain Kreatif",
                arrayOf("Corporate Public Relations", "Marketing Communications", "Media Industry Communications"))
        )
        rvProdi.adapter = AdapterProdi(listProdi, "List", this@MainActivity)
        grpTampilan.setOnCheckedChangeListener {_, checkedId ->
            val rdProdi = findViewById<RadioButton>(checkedId)
            val mode = "${rdProdi.text}"
            rvProdi.layoutManager = when(mode) {
                "List" -> LinearLayoutManager(this@MainActivity)
                "Grid" -> GridLayoutManager(this@MainActivity, 2)
                else -> StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            }
            val adapter = AdapterProdi(listProdi, mode, this@MainActivity)
            rvProdi.adapter = adapter
        }
    }
}