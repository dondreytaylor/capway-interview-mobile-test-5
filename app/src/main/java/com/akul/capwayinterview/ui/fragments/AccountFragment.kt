package com.akul.capwayinterview.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.akul.capwayinterview.R
import com.akul.capwayinterview.models.MainViewModel
import com.akul.capwayinterview.databinding.AccountFragmentBinding
import com.akul.capwayinterview.models.Transaction
import com.akul.capwayinterview.ui.adapters.TransactionListAdapter
import java.time.LocalDateTime
import java.time.Month
import java.util.*
import java.util.Calendar.MONTH

class AccountFragment : Fragment() {

    companion object {
        fun newInstance() = AccountFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: AccountFragmentBinding
//    private var navController = findNavController()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AccountFragmentBinding.inflate(inflater, container, false)
        //any programmatic setup done here
        setupClickListeners(binding, findNavController())
        val adapter = TransactionListAdapter(populateTransactionData())
        binding.transactionsList.adapter = adapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun setupClickListeners(binding: AccountFragmentBinding, navController: NavController) {
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

    private fun populateTransactionData(): Array<Transaction> {
        val transactions = arrayListOf<Transaction>()
        transactions.add(
            Transaction(
                "Domino's",
                LocalDateTime.of(2022, 2, 13, 15, 15),
                R.drawable.transaction_card_category,
                "-$2.00",
                false
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 2, 12, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $3.52",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 2, 11, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $3.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 2, 9, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $25.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 2, 3, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $100.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 31, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $3.00",
                false
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 30, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $33.00",
                false
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 29, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $43.00",
                false
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 28, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $4.00",
                false
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 27, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $66.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "American Airlines",
                LocalDateTime.of(2022, 1, 21, 19, 10),
                R.drawable.transaction_card_category,
                "- $1111.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 20, 16, 44),
                R.drawable.transaction_bank_category,
                "+ $66.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Kroger",
                LocalDateTime.of(2022, 1, 19, 15, 0),
                R.drawable.transaction_card_category,
                "- $3.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 18, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $11.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 17, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $456.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 16, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $9.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 15, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $98.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 14, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $99.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 13, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $101.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 11, 2, 15),
                R.drawable.transaction_bank_category,
                "+ $124.00",
                true
            )
        )
        transactions.add(
            Transaction(
                "Deposit from bank",
                LocalDateTime.of(2022, 1, 10, 15, 15),
                R.drawable.transaction_bank_category,
                "+ $232.00",
                false
            )
        )
        return transactions.toTypedArray()
    }

}