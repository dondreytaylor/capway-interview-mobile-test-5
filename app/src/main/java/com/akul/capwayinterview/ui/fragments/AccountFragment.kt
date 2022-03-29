package com.akul.capwayinterview.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.akul.capwayinterview.models.MainViewModel
import com.akul.capwayinterview.databinding.AccountFragmentBinding

class AccountFragment : Fragment() {

    companion object {
        fun newInstance() = AccountFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: AccountFragmentBinding
    private val navController = findNavController()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AccountFragmentBinding.inflate(inflater, container, false)
        setupClickListeners(binding, navController)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun setupClickListeners(binding: AccountFragmentBinding, navController: NavController) {
        binding.tabMenuStatementsButton.setOnClickListener {
            val action = AccountFragmentDirections.actionMainFragmentToStatementsFragment()
            navController.navigate(action)
        }
        binding.tabMenuActivityButton.setOnClickListener {
            val action = AccountFragmentDirections.actionMainFragmentToActivityFragment()
            navController.navigate(action)
        }
        binding.tabMenuMoneygoalsButton.setOnClickListener {
            val action = AccountFragmentDirections.actionMainFragmentToMoneyGoalsFragment()
            navController.navigate(action)
        }
    }

}