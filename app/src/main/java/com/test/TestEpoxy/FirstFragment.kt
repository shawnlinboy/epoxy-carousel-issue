package com.test.TestEpoxy

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.telephony.ims.ProvisioningManager.FeatureProvisioningCallback
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.carousel
import com.test.TestEpoxy.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = mutableListOf<EpoxyModel<*>>()
        for (i in 0 until 10) {
            model.add( ItemCustomViewModel_().apply {
                id("ItemCustomViewModel_$i")
                title("$i")
            })
        }
        binding.textviewFirst.withModels {

            carousel {
                id("carousel")
                models(model)
            }
        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}