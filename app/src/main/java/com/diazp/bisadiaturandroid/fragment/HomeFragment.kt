package com.diazp.bisadiaturandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.diazp.bisadiaturandroid.R
import com.diazp.bisadiaturandroid.adapter.AdapterProduk
import com.diazp.bisadiaturandroid.adapter.AdapterSlider
import com.diazp.bisadiaturandroid.model.Produk
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var vpSlider: ViewPager
    lateinit var rvRiwayat: RecyclerView
    lateinit var rvFavorit: RecyclerView
    lateinit var rvPilihan: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)
        rvRiwayat = view.findViewById(R.id.rv_riwayat)
        rvFavorit = view.findViewById(R.id.rv_favorit)
        rvPilihan = view.findViewById(R.id.rv_pilihan)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.image_1)
        arrSlider.add(R.drawable.image_2)
        arrSlider.add(R.drawable.image_3)
        arrSlider.add(R.drawable.image_4)
        arrSlider.add(R.drawable.image_5)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        rvRiwayat.adapter = AdapterProduk(arrRiwayat)
        rvRiwayat.layoutManager = layoutManager

        rvFavorit.adapter = AdapterProduk(arrFavorit)
        rvFavorit.layoutManager = layoutManager2

        rvPilihan.adapter = AdapterProduk(arrPilihan)
        rvPilihan.layoutManager = layoutManager3

        return view
    }

    val arrRiwayat: ArrayList<Produk>get() {
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "GOR Badminton Rahayu"
        p1.harga = "Rp80.000"
        p1.gambar = R.drawable.sample_1

        val p2 = Produk()
        p2.nama = "The Edge"
        p2.harga = "Rp800.000"
        p2.gambar = R.drawable.sample_2

        val p3 = Produk()
        p3.nama = "KM Bengkel Spesialis Honda"
        p3.harga = "Rp400.000"
        p3.gambar = R.drawable.sample_3

        val p4 = Produk()
        p4.nama = "Dahari Cafe"
        p4.harga = "Rp40.000"
        p4.gambar = R.drawable.sample_4

        val p5 = Produk()
        p5.nama = "Cafe Kupu-Kupu"
        p5.harga = "Rp35.000"
        p5.gambar = R.drawable.sample_5

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)
        arr.add(p5)

        return arr
    }

    val arrFavorit: ArrayList<Produk>get() {
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "GOR Badminton Rahayu"
        p1.harga = "Rp80.000"
        p1.gambar = R.drawable.sample_1

        val p2 = Produk()
        p2.nama = "The Edge"
        p2.harga = "Rp800.000"
        p2.gambar = R.drawable.sample_2

        val p3 = Produk()
        p3.nama = "KM Bengkel Spesialis Honda"
        p3.harga = "Rp400.000"
        p3.gambar = R.drawable.sample_3

        val p4 = Produk()
        p4.nama = "Dahari Cafe"
        p4.harga = "Rp40.000"
        p4.gambar = R.drawable.sample_4

        val p5 = Produk()
        p5.nama = "Cafe Kupu-Kupu"
        p5.harga = "Rp35.000"
        p5.gambar = R.drawable.sample_5

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)
        arr.add(p5)

        return arr
    }

    val arrPilihan: ArrayList<Produk>get() {
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "GOR Badminton Rahayu"
        p1.harga = "Rp80.000"
        p1.gambar = R.drawable.sample_1

        val p2 = Produk()
        p2.nama = "The Edge"
        p2.harga = "Rp800.000"
        p2.gambar = R.drawable.sample_2

        val p3 = Produk()
        p3.nama = "KM Bengkel Spesialis Honda"
        p3.harga = "Rp400.000"
        p3.gambar = R.drawable.sample_3

        val p4 = Produk()
        p4.nama = "Dahari Cafe"
        p4.harga = "Rp40.000"
        p4.gambar = R.drawable.sample_4

        val p5 = Produk()
        p5.nama = "Cafe Kupu-Kupu"
        p5.harga = "Rp35.000"
        p5.gambar = R.drawable.sample_5

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)
        arr.add(p5)

        return arr
    }
}