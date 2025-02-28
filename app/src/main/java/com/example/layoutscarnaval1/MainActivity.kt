import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BlackBackgroundScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(
            text = "Carnaval",
            color = Color.White,
            modifier = Modifier.padding(16.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        )

        Text(
            text = "Title",
            color = Color.White,
            modifier = Modifier.offset(x = (-13).dp),
            style = TextStyle(
                fontSize = 17.sp
            )
        )

        Text(
            text = "Status",
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 85.dp)
                .offset(x = (-13).dp),
            style = TextStyle(
                fontSize = 18.sp
            )
        )

        Text(
            text = "Priority",
            color = Color.White,
            modifier = Modifier
                .offset(x = (-13).dp),
            style = TextStyle(
                fontSize = 18.sp
            )
        )

        Text(
            text = "Time and Date",
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 90.dp)
                .offset(x = (-13).dp),
            style = TextStyle(
                fontSize = 18.sp
            )
        )
    }
}

@Composable
fun BlueWaterLine() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(60.dp))

        Divider(
            color = Color(0xFF00FFFF),
            thickness = 1.5.dp,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(80.dp))

        Divider(
            color = Color(0xFF00FFFF),
            thickness = 1.5.dp,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun PreviewBlackBackgroundScreen() {
    BlackBackgroundScreen()
    BlueWaterLine()
}
