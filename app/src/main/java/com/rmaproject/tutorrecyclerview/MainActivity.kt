package com.rmaproject.tutorrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rmaproject.tutorrecyclerview.adapter.RecyclerViewAdapter
import com.rmaproject.tutorrecyclerview.dataclass.Makanan

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listMakanan = listOf(
            "Sate",
            "Soto",
            "Bakso",
            "Mie Ayam",
            "Seblak",
            "Tai Goreng",
            "Nasi Goreng",
            "Nasi Padang",
            "Nasi Uduk",
            "Mie Aceh"
        )

        val detailMakanan = listOf(
            "Sate adalah makanan yang terbuat dari daging sapi yang diolah dengan bumbu-bumbu yang ditambahkan dengan air dan minyak",
            "Soto adalah makanan yang terbuat dari daging sapi yang diolah dengan bumbu-bumbu yang ditambahkan dengan air dan minyak",
            "Bakso adalah makanan yang terbuat dari daging sapi yang diolah dengan bumbu-bumbu yang ditambahkan dengan air dan minyak",
            "Mie Ayam adalah makanan yang terbuat dari daging sapi yang diolah dengan bumbu-bumbu yang ditambahkan dengan air dan minyak",
            "Seblak adalah makanan yang terbuat dari daging sapi yang diolah dengan bumbu-bumbu yang ditambahkan dengan air dan minyak",
            "Tai Goreng adalah makanan yang terbuat dari daging sapi yang diolah dengan bumbu-bumbu yang ditambahkan dengan air dan minyak",
            "Nasi Goreng adalah makanan yang terbuat dari daging sapi yang diolah dengan bumbu-bumbu yang ditambahkan dengan air dan minyak",
            "Nasi Padang adalah makanan yang terbuat dari daging sapi yang diolah dengan bumbu-bumbu yang ditambahkan dengan air dan minyak",
            "Nasi Uduk adalah makanan yang terbuat dari daging sapi yang diolah dengan bumbu-bumbu yang ditambahkan dengan air dan minyak",
            "Mie Aceh adalah makanan yang terbuat dari daging sapi yang diolah dengan bumbu-bumbu yang ditambahkan dengan air dan minyak"
        )

        val listMakananFinal = arrayListOf<Makanan>()

        for (i in listMakanan.indices) {
            val makanan = listMakanan[i]
            val detail = detailMakanan[i]
            val makananFinal = Makanan(makanan, detail)
            listMakananFinal.add(makananFinal)
        }

        val adapter = RecyclerViewAdapter(listMakananFinal)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter

        adapter.listener = { makanan ->
            Toast.makeText(this, makanan.namaMakanan, Toast.LENGTH_SHORT).show()
        }
    }
}