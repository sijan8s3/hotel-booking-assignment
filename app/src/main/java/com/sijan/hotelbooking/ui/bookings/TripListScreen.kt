package com.sijan.hotelbooking.ui.bookings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sijan.hotelbooking.R
import com.sijan.hotelbooking.ui.data.Trip

@Composable
fun TripListScreen(navController: NavController) {
    val trips = listOf(
        Trip("Paris Romance", "France", 5, "Medium", "https://source.unsplash.com/random/800x600?paris"),
        Trip("Venice Dream", "Italy", 4, "High", "https://source.unsplash.com/random/800x600?venice"),
        Trip("Barcelona Bliss", "Spain", 3, "Low", "https://source.unsplash.com/random/800x600?barcelona"),
        Trip("Santorini Serenity", "Greece", 7, "High", "https://source.unsplash.com/random/800x600?santorini"),
        Trip("Amalfi Coast Adventure", "Italy", 6, "High", "https://source.unsplash.com/random/800x600?amalfi"),
        Trip("Swiss Alps Escape", "Switzerland", 5, "High", "https://source.unsplash.com/random/800x600?swissalps")
    )

    LazyColumn {
        item {
            Text(
                text = "Where do you like to visit this Spring?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp, 12.dp)
            )

        }
        items(trips) { trip ->
            TripItem(trip = trip, onClick = {
                navController.navigate("tripDetail")
            })
        }
    }
}

@Composable
fun TripItem(trip: Trip, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left side: Name, Country, Trip Days, Budget
        Column(modifier = Modifier.weight(1f)) {
            Text(text = trip.name, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = trip.country, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Trip days: ${trip.days}", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Budget: ${trip.budget}", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }

        // Right side: Photo
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(trip.imageRes)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.baseline_trip_24),
            contentDescription = trip.name,
            modifier = Modifier
                .size(100.dp)
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop,
            alignment = Alignment.CenterEnd
        )
    }
}
