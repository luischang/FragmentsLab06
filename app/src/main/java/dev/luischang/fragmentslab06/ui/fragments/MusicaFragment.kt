package dev.luischang.fragmentslab06.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.luischang.fragmentslab06.R
import dev.luischang.fragmentslab06.ui.adapter.SongAdapter
import dev.luischang.fragmentslab06.ui.model.SongModel


class MusicaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_musica, container, false)

        val rvMusica: RecyclerView = view.findViewById(R.id.rvMusica)
        rvMusica.layoutManager = LinearLayoutManager(requireContext())
        rvMusica.adapter = SongAdapter(ListSong())

        return view
    }

    private fun ListSong(): List<SongModel>{
        var lstSong: ArrayList<SongModel> = ArrayList()

        lstSong.add(
            SongModel(1,R.drawable.freak
                        ,"Freak on a leash"
                        ,"Follow the Leader"
                        ,"100,000"
                        , "3:20"))
        lstSong.add(
            SongModel(2,R.drawable.blind
                ,"Blind"
                ,"Korn"
                ,"220,000"
                , "4:15"))
        lstSong.add(
            SongModel(3,R.drawable.fallingawayfromme
                ,"Falling Away from Me"
                ,"Issues"
                ,"330,000"
                , "5:10"))
        lstSong.add(
            SongModel(4,R.drawable.gotthelife
                ,"Got the life"
                ,"Follow the Leader"
                ,"280,000"
                , "4:44"))
        lstSong.add(
            SongModel(5,R.drawable.adidas
                ,"A.D.I.D.A.S"
                ,"Korn"
                ,"550,000"
                , "4:28"))
        return lstSong
    }
}