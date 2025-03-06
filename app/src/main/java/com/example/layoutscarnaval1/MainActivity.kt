package com.example.layoutscarnaval1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListScreen()
        }
    }
}

@Composable
fun TodoListScreen() {
    var title by remember { mutableStateOf(TextFieldValue()) }
    var status by remember { mutableStateOf("Not Done") }
    var priority by remember { mutableStateOf("Medium") }
    var date by remember { mutableStateOf("2014-02-13") }
    var time by remember { mutableStateOf("17:52:00") }
    val calendar = Calendar.getInstance()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(text = "Title", color = Color.White, fontSize = 20.sp)
        BasicTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Status", color = Color.White, fontSize = 18.sp)
        Row {
            RadioButton(selected = status == "Done", onClick = { status = "Done" })
            Text(text = "Done", color = Color.White)
            Spacer(modifier = Modifier.width(10.dp))
            RadioButton(selected = status == "Not Done", onClick = { status = "Not Done" })
            Text(text = "Not Done", color = Color.White)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Priority", color = Color.White, fontSize = 18.sp)
        Row {
            RadioButton(selected = priority == "Low", onClick = { priority = "Low" })
            Text(text = "Low", color = Color.White)
            Spacer(modifier = Modifier.width(10.dp))
            RadioButton(selected = priority == "Medium", onClick = { priority = "Medium" })
            Text(text = "Medium", color = Color.White)
            Spacer(modifier = Modifier.width(10.dp))
            RadioButton(selected = priority == "High", onClick = { priority = "High" })
            Text(text = "High", color = Color.White)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Time and Date", color = Color.White, fontSize = 18.sp)
        Text(text = date, color = Color.White)
        Text(text = time, color = Color.White)

        Row(modifier = Modifier.padding(top = 10.dp)) {
            Button(onClick = {
                val datePicker = DatePickerDialog(
                    context,
                    { _, year, month, day ->
                        date = "$year-${month + 1}-$day"
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )
                datePicker.show()
            }) {
                Text(text = "Choose Date")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                val timePicker = TimePickerDialog(
                    context,
                    { _, hour, minute ->
                        time = String.format("%02d:%02d:00", hour, minute)
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true
                )
                timePicker.show()
            }) {
                Text(text = "Choose Time")
            }
        }

        Row(modifier = Modifier.padding(top = 10.dp)) {
            Button(onClick = {
                title = TextFieldValue()
                status = "Not Done"
                priority = "Medium"
                date = "2014-02-13"
                time = "17:52:00"
            }) {
                Text(text = "Reset")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                Toast.makeText(context, "Task Submitted", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Submit")
            }
        }
    }
}
