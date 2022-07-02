package ru.kpfu.itis.homework2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.kpfu.itis.homework2.databinding.FragmentAnimeBinding

class AnimeFragment : Fragment(R.layout.fragment_anime) {
    private var _binding: FragmentAnimeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnimeBinding.bind(view)

        with(binding) {
            btnSecretAnime.setOnClickListener {
                findNavController().navigate(
                    R.id.action_animeFragment_to_secretFragment,
                    SecretFragment.createBundle(
                        (getString(R.string.anime_fragment_value)).toString()
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