package com.sijan.hotelbooking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.sijan.hotelbooking.ui.auth.LoginScreen
import com.sijan.hotelbooking.ui.auth.RegisterScreen
import com.sijan.hotelbooking.ui.auth.UserDetailsScreen
import com.sijan.hotelbooking.ui.bookings.BookingConfirmedScreen
import com.sijan.hotelbooking.ui.bookings.BookingScreen
import com.sijan.hotelbooking.ui.bookings.TripDetailScreen
import com.sijan.hotelbooking.ui.bookings.TripListScreen
import com.sijan.hotelbooking.ui.theme.HotelBookingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HotelBookingTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController = navController) }
        composable("register") { RegisterScreen(navController = navController) }
        composable("userDetails") { UserDetailsScreen(navController = navController) }
        composable("tripList") { TripListScreen(navController = navController) }
        composable("tripDetail") { TripDetailScreen(navController = navController) }
        composable("booking") { BookingScreen(navController = navController) }
        composable("bookingConfirmed") { BookingConfirmedScreen(navController = navController) }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HotelBookingTheme {
        Surface {
            Navigation(navController = rememberNavController())
        }
    }
}
