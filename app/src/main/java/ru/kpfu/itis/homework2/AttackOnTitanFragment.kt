package ru.kpfu.itis.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.kpfu.itis.homework2.databinding.FragmentAttackOnTitanBinding

class AttackOnTitanFragment : Fragment(R.layout.fragment_attack_on_titan) {
    private var _binding: FragmentAttackOnTitanBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAttackOnTitanBinding.bind(view)

        with(binding) {
            btnSecretAttack.setOnClickListener {
                findNavController().navigate(
                    R.id.action_attackOnTitanFragment_to_secretFragment,
                    SecretFragment.createBundle(
                        (getString(R.string.attack_fragment_value)).toString()
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