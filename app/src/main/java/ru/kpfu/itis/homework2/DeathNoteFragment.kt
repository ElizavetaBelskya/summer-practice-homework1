package ru.kpfu.itis.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.kpfu.itis.homework2.databinding.FragmentDeathNoteBinding

class DeathNoteFragment : Fragment(R.layout.fragment_death_note) {
    private var _binding: FragmentDeathNoteBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDeathNoteBinding.bind(view)

        with(binding) {
            btnSecretDeathNote.setOnClickListener {
                findNavController().navigate(
                    R.id.action_deathNoteFragment_to_secretFragment,
                    SecretFragment.createBundle(
                        (getString(R.string.deathnote_fragment_value))
                    ),
                )
            }
        }
    }

}