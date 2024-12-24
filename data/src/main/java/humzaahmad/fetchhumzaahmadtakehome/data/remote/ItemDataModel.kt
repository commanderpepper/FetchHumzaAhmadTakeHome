package humzaahmad.fetchhumzaahmadtakehome.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class ItemDataModel(
    val id: Int,
    val listId: Int,
    val name: String? = null
)
