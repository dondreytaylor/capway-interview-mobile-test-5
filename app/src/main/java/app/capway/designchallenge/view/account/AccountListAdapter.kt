package app.capway.designchallenge.view.account

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.capway.designchallenge.R
import app.capway.designchallenge.model.Transaction

class AccountListAdapter(val context: Context?, val dataList: ArrayList<Transaction>)
    : RecyclerView.Adapter<AccountListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageViewMoney: ImageView = itemView.findViewById<View>(R.id.image_view_money) as ImageView
        var imageViewBank: ImageView = itemView.findViewById<View>(R.id.image_view_bank) as ImageView
        var nameTextView: TextView = itemView.findViewById<View>(R.id.name) as TextView
        var timestampTextView: TextView = itemView.findViewById<View>(R.id.timestamp) as TextView
        var amountTextView: TextView = itemView.findViewById<View>(R.id.amount) as TextView
        var pendingTextView: TextView = itemView.findViewById<View>(R.id.pending) as TextView
    }

    /**
     * Overridden method that creates a viewHolder class
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(
            R.layout.item_transaction,
            parent, false
        )
        return ViewHolder(listItem)
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listData: Transaction = dataList[position]

        val drawable = holder.imageViewBank.resources.getDrawable(listData.itemImageId)
        holder.imageViewMoney.setImageDrawable(drawable)
        holder.imageViewBank.setImageDrawable(drawable)
        holder.nameTextView.text = listData.name
        holder.timestampTextView.text = listData.timestamp
        holder.amountTextView.text = listData.amount
        if (listData.isDeposit) {
            holder.imageViewMoney.visibility = View.GONE
            holder.imageViewBank.visibility = View.VISIBLE
            holder.amountTextView.text = "+" + listData.amount
            val color = holder.amountTextView.getResources().getColor(R.color.capWay_green)
            holder.amountTextView.setTextColor(color)
        } else {
            holder.imageViewMoney.visibility = View.VISIBLE
            holder.imageViewBank.visibility = View.GONE
            holder.amountTextView.text = "-" + listData.amount
            val color = holder.amountTextView.getResources().getColor(R.color.capWay_red)
            holder.amountTextView.setTextColor(color)
        }

        if (listData.isPending) {
            holder.pendingTextView.visibility = View.VISIBLE
        } else {
            holder.pendingTextView.visibility = View.GONE
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return dataList.size
    }


}