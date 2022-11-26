package com.example.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.composition.R
import com.example.composition.databinding.FragmentChooseLevelBinding
import com.example.composition.domain.entity.Level
import java.lang.RuntimeException

class ChooseLevelFragment : Fragment() {
    private var _binding: FragmentChooseLevelBinding?=null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding==null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentChooseLevelBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchGame()
    }

    private fun launchGame(){
        binding.buttonLevelTest.setOnClickListener {
            fragmentNavigation(Level.TEST)
        }
        binding.buttonLevelEasy.setOnClickListener {
            fragmentNavigation(Level.EASY)
        }
        binding.buttonLevelNormal.setOnClickListener {
            fragmentNavigation(Level.NORMAL)
        }
        binding.buttonLevelHard.setOnClickListener {
            fragmentNavigation(Level.HARD)
        }
    }

    private fun fragmentNavigation(level: Level){
        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(level)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}