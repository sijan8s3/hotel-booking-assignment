package com.sijan.hotelbooking.ui.bookings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sijan.hotelbooking.R

@Composable
fun BookingScreen(navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var numPeople by remember { mutableStateOf("") }
    var dateOfVisit by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Trip Booking", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://source.unsplash.com/random/800x600?paris")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.baseline_holiday_village_24),
                    contentDescription = "",
                    modifier = Modifier
                        .width(160.dp)
                        .height(100.dp)
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )

                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = "Paris Romance",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Days: 5",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Budget: Medium",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = contact,
            onValueChange = { contact = it },
            label = { Text("Contact") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = numPeople,
            onValueChange = { numPeople = it },
            label = { Text("Number of People") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = dateOfVisit,
            onValueChange = { dateOfVisit = it },
            label = { Text("Date of Visit") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("bookingConfirmed") },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Request Booking")
        }
    }
}