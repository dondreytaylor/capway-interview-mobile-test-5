package app.capway.designchallenge.view.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.capway.designchallenge.R
import app.capway.designchallenge.model.Transaction

/**
 * A placeholder fragment containing a simple view.
 */
class AccountListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Pull data out of arguments

        val view = inflater.inflate(R.layout.fragment_account_list, container, false)
        recyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = AccountListAdapter(context?.applicationContext,
            arguments?.getSerializable(AccountListFragment.ARG_DATA) as ArrayList<Transaction>
        )
        return view
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_DATA = "arg_data"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(transactionList: ArrayList<Transaction>?): AccountListFragment {
            val transaction: Transaction?
            return AccountListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(AccountListFragment.ARG_DATA, transactionList)
                }
            }
        }
    }
}