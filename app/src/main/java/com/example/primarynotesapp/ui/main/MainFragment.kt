package com.example.primarynotesapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.primarynotesapp.R
import com.example.primarynotesapp.databinding.FragmentMainBinding
import com.example.primarynotesapp.ui.recyclerview.NotesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: NotesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        observeLastText()
    }

    private fun setListeners() {
        binding.btnSaveNote.setOnClickListener {
            handleInsertText()
        }

        binding.btnShowList.setOnClickListener {
            navigateToTextList()
        }
    }

    private fun handleInsertText() {
        val inputText = binding.etNote.text.toString()
        viewModel.insertText(inputText)
        clearInputText()
    }

    private fun clearInputText() {
        binding.etNote.setText("")
    }

    private fun navigateToTextList() {
        findNavController().navigate(R.id.action_mainFragment_to_NotesListFragment)
    }

    private fun observeLastText() {
        viewModel.lastText.observe(viewLifecycleOwner) {
            binding.twNote.text = getString(R.string.tv_hello_with_text)
        }
    }
}