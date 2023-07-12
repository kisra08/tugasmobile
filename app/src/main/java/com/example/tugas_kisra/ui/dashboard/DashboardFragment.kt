package com.example.tugas_kisra.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_kisra.adapter.AdapterObat
import com.example.tugas_kisra.app.ApiConfig
import com.example.tugas_kisra.R
import com.example.tugas_kisra.databinding.FragmentDashboardBinding
import com.example.tugas_kisra.model.ObatModel
import com.example.tugas_kisra.model.ResponModel
import retrofit2.Call
import retrofit2.Response

class DashboardFragment : Fragment() {

    lateinit var rvObat: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)

        init(view)
        getobat()
        return view
    }

    private var listObat: ArrayList<ObatModel> = ArrayList()

    fun getobat(){
        ApiConfig.instanceRetrofit.getObat().enqueue(object :
            retrofit2.Callback<ResponModel> {

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val res = response.body()!!
                listObat = res.obat
                displayObat()
            }
            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayObat() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvObat.adapter = AdapterObat(requireActivity(), listObat)
        rvObat.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvObat=view.findViewById(R.id.recyler_view)
    }

}