package app.capway.designchallenge.view

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import app.capway.designchallenge.databinding.ActivityMainBinding
import app.capway.designchallenge.view.account.MainActivityListener
import app.capway.designchallenge.view.account.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout


/**
 * Main screen Activity class of the Challenge App.  Sets up the ViewPager and
 * sections adapter.  It also sets up lambdas for some listener events.
 */
class MainActivity : AppCompatActivity(), MainActivityListener {

    private lateinit var binding: ActivityMainBinding
    private var isLocked = false

    /**
     * State change handler for the Created state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Build a sections adapter for the list view pager
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

        // Sets up test page for bottom nav buttons
        binding.navigation.setOnItemSelectedListener {
            val intent = Intent(this, BlankActivity::class.java)
            startActivity(intent)
            return@setOnItemSelectedListener true
        }

        // Click listener for special list down button in toolbar
        binding.listDown.setOnClickListener{
            onListDownEvent()
        }
    }
    /**
     * Called when the user touches chip button
     */
    fun gotoNextPage(view: View) {
        // Do something in response to button click
        val intent = Intent(this, BlankActivity::class.java)
        startActivity(intent)
    }

    /**
     * Handles a Fling scroll event coming back from one of the fragment lists.
     * The function hides the header fields and adjusts the top margin for the
     * tabs to lock the list into a header-less configuration.
     */
    override fun onScrollEvent() {
        // If the state is locked don't be redundant for
        // hiding of the header fields
        if (isLocked) {
            return
        }

        // Hide header fields
        binding.accountBalance.visibility = View.GONE
        binding.textAccountBalanceDesc.visibility = View.GONE
        binding.textPendingChargesDesc.visibility = View.GONE
        binding.textPendingChargesAmount.visibility = View.GONE
        binding.lineDivider.visibility = View.GONE
        binding.imageCreditCard.visibility = View.GONE
        binding.capwayCardTitle.visibility = View.GONE
        binding.capwayCardStatusDesc.visibility = View.GONE
        binding.cardOptionsActions.visibility = View.GONE

        // Now that the list is locked, show the toggle arrow
        // button on the toolbar
        binding.listDown.visibility = View.VISIBLE

        // Formats top margin position for the tabs and lists
        formatTabs(130.0f)

        // Set the locked state to true.  The header is gone
        // and the tab vertical location is adjusted.
        isLocked = true
    }

    /**
     * Handles the pressing of the down button on the toolbar making the header
     * fields visible and adjusting the placement of the transaction list tabs
     * to their starting location where the list is unlocked.
     */
    fun onListDownEvent() {
        // Set the lock state to false
        isLocked = false

        // Show all of the header fields
        binding.accountBalance.visibility = View.VISIBLE
        binding.textAccountBalanceDesc.visibility = View.VISIBLE
        binding.textPendingChargesDesc.visibility = View.VISIBLE
        binding.textPendingChargesAmount.visibility = View.VISIBLE
        binding.lineDivider.visibility = View.VISIBLE
        binding.imageCreditCard.visibility = View.VISIBLE
        binding.capwayCardTitle.visibility = View.VISIBLE
        binding.capwayCardStatusDesc.visibility = View.VISIBLE
        binding.cardOptionsActions.visibility = View.VISIBLE

        // Now that the list is being restored, hide the down
        // arrow
        binding.listDown.visibility = View.GONE

        // Formats top margin position for the tabs and lists
        formatTabs(383.0f)
    }

    /**
     * Formats the tab top margin position based on desired
     * dip measurement converting it to pixels to set the top
     * margin.
     */
    private fun formatTabs(dpYPos: Float) {
        // Get the tabs View object
        val tabs = binding.tabs

        // Calculate pixels for dip
        val r: Resources = getResources()
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpYPos,
            r.getDisplayMetrics()
        ).toInt()

        // Store the current margins to set default values.
        // Set top margin as a pixel measurement
        val parameter = tabs.getLayoutParams() as ConstraintLayout.LayoutParams

        // Set all the margins with three coming from default values.
        // As a result on the top margin is changed to the calculated value
        parameter.setMargins(
            parameter.leftMargin,
            px, // Top margin
            parameter.rightMargin,
            parameter.bottomMargin
        ) // left, top, right, bottom

        // Now that we're setup, the final adjustment of the top margin
        tabs.setLayoutParams(parameter)
    }
}