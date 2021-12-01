package com.example.roomdatabase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.databinding.FragmentBlank1Binding

//Declares BlankFragment1 as a subclass of Fragment. Notice the import.
class BlankFragment1 : Fragment() {

    private var _binding: FragmentBlank1Binding? = null
    private val binding get() = _binding!!

    // Provides a method for creating new instances of the fragment, a factory method.
    companion object {

        fun newInstance(): BlankFragment1 {
            return BlankFragment1()
        }
    }

    // Creates the view for the fragment. Whereas Activities use setContentView()
    // to specify the XML file that defines their layouts
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Specifies whether the inflated fragment should be added to the container.
        // The container is the parent view that will hold the fragment’s view hierarchy.
        // You should always set this to false bc FragmentManager will take care of adding the
        // fragment to the container
        //  return inflater.inflate(R.layout.fragment_blank1, container, false)
        _binding = FragmentBlank1Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView).setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment1_to_blankFragment2)
        }
     /*   override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        } */
    }
}



