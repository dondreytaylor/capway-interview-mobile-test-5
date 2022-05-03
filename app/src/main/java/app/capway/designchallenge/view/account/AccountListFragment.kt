package app.capway.designchallenge.view.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.capway.designchallenge.R
import app.capway.designchallenge.model.Transaction


/**
 * A placeholder fragment containing a simple view.
 */
class AccountListFragment(transactionList: ArrayList<Transaction>) : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var transactionList: ArrayList<Transaction>
    init {
       this.transactionList = transactionList
    }

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
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = AccountListAdapter(context, this.transactionList)
        return view
    }
}