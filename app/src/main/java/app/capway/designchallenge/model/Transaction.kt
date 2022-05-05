package app.capway.designchallenge.model
import kotlinx.serialization.Serializable

@Serializable
data class Transaction(val itemImageId: Int, val name: String,
                  val amount: String, val timestamp: String,
                  val isPending: Boolean, val isDeposit: Boolean = false)  {
}