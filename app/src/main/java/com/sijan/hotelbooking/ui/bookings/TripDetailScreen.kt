package com.sijan.hotelbooking.ui.bookings

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sijan.hotelbooking.R
import com.sijan.hotelbooking.ui.data.Hotel
import com.sijan.hotelbooking.ui.data.Place
import com.sijan.hotelbooking.ui.data.Trip


@Composable
fun TripDetailScreen(navController: NavController) {
    val trip = Trip(
        "Paris Romance", "France", 5, "Medium",
        "https://source.unsplash.com/random/800x600?paris", listOf(
            Hotel("Hotel Le Meurice", "5-star luxury hotel", "https://source.unsplash.com/random/800x600?hotel-paris-beautiful"),
            Hotel("Hotel Ritz Paris", "Historic luxury hotel", "https://source.unsplash.com/random/800x600?hotel-paris"),
            Hotel("Four Seasons Hotel George V", "Palatial luxury hotel", "https://source.unsplash.com/random/800x600?hotel")
        ),
        listOf(
            Place("Eiffel Tower", "Iconic landmark", "https://source.unsplash.com/random/800x600?eiffeltower"),
            Place("Louvre Museum", "World's largest art museum", "https://source.unsplash.com/random/800x600?louvre"),
            Place("Montmartre", "Artistic neighborhood known for its nightlife", "https://source.unsplash.com/random/800x600?montmartre"),
            Place("Notre-Dame Cathedral", "Gothic masterpiece", "https://source.unsplash.com/random/800x600?notredame"),
            Place("Palace of Versailles", "Opulent royal residence", "https://source.unsplash.com/random/800x600?versailles")
        )
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(enabled = true, state = rememberScrollState())

    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(trip.imageRes)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.baseline_holiday_village_24),
            contentDescription = trip.name,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )

        Text(text = trip.name, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Experience the epitome of romance in \"Paris Romance\" trip, where luxury meets history in the heart of France. Stay at renowned hotels like Hotel Le Meurice and Hotel Ritz Paris, while exploring iconic landmarks such as the Eiffel Tower and the Louvre Museum. Dive into the vibrant nightlife of Montmartre, making unforgettable memories in the City of Love.", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Country: ${trip.country}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Trip days: ${trip.days}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Budget: ${trip.budget}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Accommodations:", style = MaterialTheme.typography.labelMedium)
        /*trip.hotels.forEach { hotel ->
            HotelItem(hotel = hotel)
        }*/
        Row(
            modifier = Modifier.horizontalScroll(enabled = true, state = rememberScrollState())
        ) {
            trip.hotels.forEach { hotel ->
                HotelItem(hotel = hotel)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Places to visit:", style = MaterialTheme.typography.labelMedium)
        trip.places.forEach { place ->
            PlaceItem(place = place)
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navController.navigate("booking") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Book this Trip")
        }
    }
}

@Composable
fun HotelItem(hotel: Hotel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(hotel.imageRes)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.baseline_holiday_village_24),
            contentDescription = hotel.name,
            modifier = Modifier
                .size(100.dp)
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = hotel.name, style = MaterialTheme.typography.bodyMedium)
            Text(text = hotel.description, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}

@Composable
fun PlaceItem(place: Place) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(place.imageRes)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.baseline_holiday_village_24),
            contentDescription = place.name,
            modifier = Modifier
                .size(80.dp)
                .clip(shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = place.name, style = MaterialTheme.typography.bodyMedium)
            Text(text = place.description, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}