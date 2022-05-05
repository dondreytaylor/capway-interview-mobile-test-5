package app.capway.designchallenge.view.account

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
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
    private lateinit var mainActivityListener: MainActivityListener
    private var transactionList: ArrayList<Transaction>
    init {
       this.transactionList = transactionList
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivityListener = context as MainActivityListener
    }

    /**
     * onCreateView Fragment lifecycle event.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view
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

        // Initialize the recycle view with data!
        recyclerView.adapter = AccountListAdapter(context, this.transactionList)

        // Set scroll listener
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
             // Scroll event listener here for reference in case
             // logic changes. So, this code acts as a placeholder.
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (dy > 0) {
                    println("Srolling up")
                    // Scrolling up

                } else {
                    // Scrolling down
                    println("Srolling down")
                }
            }

            /**
             * State listener response to scroll tests including Fling events.
             */
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
                    // Fling occurred so send scroll event back up to the
                    // MainActivity to lock the list without the header
                    println("Fling happened")
                    mainActivityListener.onScrollEvent()
                } else if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    // Do something
                } else {
                    // Do something
                }
            }
        })
        return view
    }
}