package humzaahmad.fetchhumzaahmadtakehome.feature.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GroupUI(modifier : Modifier = Modifier.fillMaxWidth(), group: ItemUIGroupModel){
    Column(modifier = modifier.padding(8.dp)) {
        Text(modifier = Modifier.padding(8.dp), text = "${group.groupId}", fontSize = 16.sp)
        group.items.forEach { item ->
            if(!item.name.isNullOrEmpty()){
                GroupItemUI(item = item)
            }
        }
    }
}

@Composable
fun GroupItemUI(modifier : Modifier = Modifier.fillMaxSize(), item: ItemUIModel) {
    Row(modifier = modifier.padding(4.dp)) {
        Text("\t${item.name}", fontSize = 14.sp)
    }
}

@Preview
@Composable
fun GroupUIPreview(){
    Column {
        SAMPLE_GROUPS.forEach {
            GroupUI(group = it)
        }
    }
}

private val SAMPLE_GROUPS = List(3){ index ->
    ItemUIGroupModel(groupId = index, items = List(5) { itemIndex ->
        ItemUIModel(id = itemIndex, name = "Item $itemIndex")
    })
}

data class ItemUIGroupModel(val groupId: Int, val items: List<ItemUIModel>)

data class ItemUIModel(val name: String?, val id: Int)