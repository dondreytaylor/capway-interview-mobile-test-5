package app.capway.designchallenge.view.account

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import app.capway.designchallenge.R
import app.capway.designchallenge.model.Transaction

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> AccountListFragment(getTransactions())
            1 -> AccountListFragment(getDeposits())
            2 -> AccountListFragment(getWithdrawals())
            else -> AccountListFragment(getTransactions())
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }

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