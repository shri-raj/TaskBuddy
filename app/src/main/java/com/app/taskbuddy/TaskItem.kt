package com.app.taskbuddy

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.taskbuddy.ui.theme.TaskBuddyTheme
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun TaskItem(task: TaskData, OnCompletion: () -> Unit) {

    Row (
        Modifier.padding(8.dp).fillMaxWidth()
        .border(width = 2.dp, color = androidx.compose.ui.graphics.Color.Black, shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically){
        Column(modifier = Modifier.weight(1f),verticalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = task.name,
                style = TextStyle(fontSize = 24.sp), maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.Default
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = task.date,
                style = TextStyle(fontSize = 24.sp), maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                fontSize = 16.sp
            )
        }
        IconButton(onClick = { OnCompletion() }) { Icon(Icons.Default.Delete, contentDescription = "Delete") }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    TaskItem(TaskData(1,"Testing","234sdf"),{})
}