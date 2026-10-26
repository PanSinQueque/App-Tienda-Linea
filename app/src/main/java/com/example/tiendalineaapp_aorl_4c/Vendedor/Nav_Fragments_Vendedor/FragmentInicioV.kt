package com.example.tiendalineaapp_aorl_4c.Vendedor.Nav_Fragments_Vendedor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tiendalineaapp_aorl_4c.R
import com.example.tiendalineaapp_aorl_4c.Vendedor.Bottom_Nav_Fragments_Vendedor.FragmentMisOrdenesV
import com.example.tiendalineaapp_aorl_4c.Vendedor.Bottom_Nav_Fragments_Vendedor.FragmentMisProductosV
import com.example.tiendalineaapp_aorl_4c.databinding.FragmentInicioVBinding

class FragmentInicioV : Fragment() {

    private lateinit var binding : FragmentInicioVBinding
    private lateinit var mContext : Context

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{

        binding = FragmentInicioVBinding.inflate(inflater, container, false)

        binding.BottomNavigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.op_mis_productos_v -> {
                    replaceFragment(FragmentMisProductosV())
                }
                R.id.op_mis_productos_v -> {
                    replaceFragment(FragmentMisOrdenesV())
                }
            }
            true
        }

        replaceFragment(FragmentMisProductosV())
        binding.BottomNavigation.selectedItemId = R.id.op_mis_productos_v

        binding.addFab.setOnClickListener{
            Toast.makeText(mContext, "Has presionado en botón (+)", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun replaceFragment (fragment: Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottomFragment, fragment)
            .commit()
    }

}