package com.example.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.composition.R
import com.example.composition.databinding.FragmentGameFinishedBinding
import com.example.composition.domain.entity.GameResult
import java.lang.RuntimeException

class GameFinishedFragment : Fragment() {
    private var _binding:FragmentGameFinishedBinding?=null
    private val binding:FragmentGameFinishedBinding
    get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding==null")

    private val args by navArgs<GameFinishedFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentGameFinishedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
        binding.gameResult=args.gameResult
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun retryGame(){
        findNavController().popBackStack()
    }
}