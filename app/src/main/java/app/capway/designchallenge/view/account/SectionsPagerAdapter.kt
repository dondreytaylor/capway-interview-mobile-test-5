package app.capway.designchallenge.view.account

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import app.capway.designchallenge.R
import app.capway.designchallenge.model.Transaction

/**
 * Array of tab titles from automatic processing.
 */
private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.  The loaded fragment contains example
 * test data to show off list with simulated values.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    /**
     * Returns Fragment for the matching position and tab title.
     */
    override fun getItem(position: Int): Fragment {
        // When clause that returns the AccountListFragment filled
        // with appropriate data into the Fragment object.
        return when (position) {
            0 -> AccountListFragment(getTransactions())
            1 -> AccountListFragment(getDeposits())
            2 -> AccountListFragment(getWithdrawals())
            else -> AccountListFragment(getTransactions())
        }
    }

    /**
     * Callback to get title from the array of tab titles.
     */
    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    /**
     * Callback for count of tabs.
     */
    override fun getCount(): Int {
        return 3
    }

    /**
     * Returns a list of test withdrawal transactions.
     */
    private fun getWithdrawals(): ArrayList<Transaction> {
        val resultReturn: ArrayList<Transaction> = arrayListOf()
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Withdrawal from bank",
                "$100.00", "12/15/2021 at 6:10PM",
                true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Withdrawal from bank ATM",
                "$50.00", "11/17/2021 at 10:50PM",
                true, isDeposit = true)
        )
        return resultReturn
    }

    /**
     * Returns a list of test deposit transactions.
     */
    private fun getDeposits() : ArrayList<Transaction> {
        val resultReturn: ArrayList<Transaction> = arrayListOf()
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$100.00", "12/15/2021 at 6:10PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$50.00", "11/17/2021 at 10:50PM", true, isDeposit = true)
        )
        return resultReturn
    }

    /**
     * Returns list of all test transactions -- a larger list.
     */
    private fun getTransactions(): ArrayList<Transaction>  {
        val resultReturn: ArrayList<Transaction> = arrayListOf()

        resultReturn.add(
            Transaction(R.drawable.ic_money, "Domino's",
            "$7.00", "12/17/2021 at 5:30PM", false, isDeposit = false)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
            "$100.00", "12/15/2021 at 6:10PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
            "$50.00", "11/17/2021 at 10:50PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
            "$25.00", "11/15/2021 at 1:47PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_money, "Domino's",
                "$7.00", "10/17/2021 at 5:30PM", false, isDeposit = false)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$25.00", "12/08/2021 at 1:47PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$25.00", "3/07/2021 at 1:47PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$50.00", "11/17/2021 at 10:50PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$25.00", "11/15/2021 at 1:47PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_money, "Domino's",
                "$7.00", "10/17/2021 at 5:30PM", false, isDeposit = false)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$25.00", "12/08/2021 at 1:47PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$25.00", "3/07/2021 at 1:47PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$50.00", "11/17/2021 at 10:50PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$25.00", "11/15/2021 at 1:47PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_money, "Domino's",
                "$7.00", "10/17/2021 at 5:30PM", false, isDeposit = false)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$25.00", "12/08/2021 at 1:47PM", true, isDeposit = true)
        )
        resultReturn.add(
            Transaction(R.drawable.ic_bank, "Deposit from bank",
                "$25.00", "3/07/2021 at 1:47PM", true, isDeposit = true)
        )
        return resultReturn
    }
}