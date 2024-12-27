package humzaahmad.fetchhumzaahmadtakehome.feature.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ItemsScreen(modifier: Modifier, viewModel: ItemsViewModel = hiltViewModel()){
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    when(uiState.value){
        is ItemsScreenState.Success -> {
            ItemsScreen(modifier = modifier, groups = (uiState.value as ItemsScreenState.Success).groups)
        }
        is ItemsScreenState.Error -> {
            ItemsScreenColumn(modifier){
                Text(modifier = Modifier.padding(16.dp), text = (uiState.value as ItemsScreenState.Error).message)
            }
        }
        ItemsScreenState.Loading -> {
            ItemsScreenColumn(modifier = modifier) {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
private fun ItemsScreenColumn(
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        content()
    }
}

@Composable
fun ItemsScreen(modifier: Modifier, groups: List<ItemUIGroupModel>){
    Column(modifier = modifier.fillMaxSize().verticalScroll(state = rememberScrollState())) {
        groups.forEach { group ->
            GroupUI(group = group)
        }
    }
}