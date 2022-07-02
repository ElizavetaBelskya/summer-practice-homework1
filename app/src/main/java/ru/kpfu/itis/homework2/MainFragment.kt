package ru.kpfu.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import ru.kpfu.itis.homework2.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        with(binding) {
            btnSecretMain.setOnClickListener {
                if (!etName.text.isNullOrEmpty() && !etWeight.text.isNullOrEmpty()
                    && !etAge.text.isNullOrEmpty() && !etHeight.text.isNullOrEmpty()) {
                    findNavController().navigate(
                        R.id.action_mainFragment_to_secretFragment,
                        SecretFragment.createBundle(
                            (getString(R.string.main_fragment_value))
                        ),
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}