package humzaahmad.fetchhumzaahmadtakehome.feature.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import humzaahmad.fetchhumzaahmadtakehome.data.repo.FetchRepository
import humzaahmad.fetchhumzaahmadtakehome.feature.items.ItemsScreenState.Error
import humzaahmad.fetchhumzaahmadtakehome.feature.items.ItemsScreenState.Loading
import humzaahmad.fetchhumzaahmadtakehome.feature.items.ItemsScreenState.Success
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(private val repo: FetchRepository): ViewModel() {
    val uiState : StateFlow<ItemsScreenState> = flow<ItemsScreenState> {
        val items = repo.getItems().filter { it.name.isNullOrBlank().not() }
        if(items.isEmpty()){
            emit(Error("No data found"))
        }
        else {
            // Group items by listId and then sort items by id
            val groups = items.groupBy { it.listId }.map {
                ItemUIGroupModel(groupId = it.key, items = it.value.map { item ->
                    ItemUIModel(id = item.id, name = item.name)
                }.sortedBy { it.id })
            }
            emit(Success(groups = groups.sortedBy { it.groupId }))
        }
    }.catch {
        emit(Error(it.message ?: "Something went wrong"))
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000L), Loading)
}

sealed class ItemsScreenState{
    data object Loading: ItemsScreenState()
    data class Error(val message: String): ItemsScreenState()
    data class Success(val groups: List<ItemUIGroupModel>): ItemsScreenState()
}