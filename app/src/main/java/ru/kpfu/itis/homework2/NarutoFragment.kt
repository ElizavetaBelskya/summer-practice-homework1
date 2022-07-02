package ru.kpfu.itis.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.kpfu.itis.homework2.databinding.FragmentNarutoBinding

class NarutoFragment : Fragment(R.layout.fragment_naruto) {
    private var _binding: FragmentNarutoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNarutoBinding.bind(view)

        with(binding) {
            btnSecretNaruto.setOnClickListener {
                findNavController().navigate(
                    R.id.action_narutoFragment_to_secretFragment,
                    SecretFragment.createBundle(
                        (getString(R.string.naruto_fragment_value))
                    ),
                )
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}