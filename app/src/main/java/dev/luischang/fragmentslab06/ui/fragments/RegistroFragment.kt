package dev.luischang.fragmentslab06.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import dev.luischang.fragmentslab06.R


class RegistroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registro, container, false)

        val btSave: Button = view.findViewById(R.id.btSave)
        val etFullName: EditText = view.findViewById(R.id.etFullName)
        val etEmail: EditText = view.findViewById(R.id.etEmail)
        val spCountry: Spinner = view.findViewById(R.id.spCountry)
        val rgGender: RadioGroup = view.findViewById(R.id.rgGender)
        val ckLicense: CheckBox = view.findViewById(R.id.ckLicense)
        val ckCar: CheckBox = view.findViewById(R.id.ckCar)

        ArrayAdapter
            .createFromResource(requireContext(),R.array.country_array,
                                android.R.layout.simple_spinner_item).also {
                                    adapter ->
                                    adapter.setDropDownViewResource(
                                        android.R.layout.simple_spinner_dropdown_item)
                    spCountry.adapter = adapter
            }
        //spCountry on ItemSelectedListener
        var spCountryValue = ""

        spCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                spCountryValue = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        btSave.setOnClickListener {
            val fullName: String = etFullName.text.toString()
            val email: String = etEmail.text.toString()
            val genderId = rgGender.checkedRadioButtonId
            val gender: String = view.findViewById<RadioButton>(genderId).text.toString()
            val country: String = spCountry.selectedItem.toString()
            val license: String = if(ckLicense.isChecked) "Si" else "No"
            val car: String = if(ckCar.isChecked) "Si" else "No"
            Toast.makeText(
                requireContext(),
                "$fullName $email $gender $country $license $car"
                , Toast.LENGTH_SHORT).show()
        }
        return view
    }
}