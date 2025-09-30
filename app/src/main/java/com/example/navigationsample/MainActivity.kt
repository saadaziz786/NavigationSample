package com.example.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsample.ui.theme.FirstScreen
import com.example.navigationsample.ui.theme.NavigationSampleTheme
import com.example.navigationsample.ui.theme.SecondScreen
import com.example.navigationsample.ui.theme.ThirdScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Scaffold { innerPadding ->
                    MyApp( modifier = Modifier.padding(innerPadding))
                }

            }
        }
    }
}

@Composable
fun MyApp( modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "FirstScreen") {
        composable(route = "FirstScreen") {
            FirstScreen {
                navController.navigate("SecondScreen")
            }
        }
        composable(route = "SecondScreen") {
            SecondScreen {
                navController.navigate("ThirdScreen")
            }
        }
        composable(route = "ThirdScreen") {
            ThirdScreen {
                navController.navigate("FirstScreen")
            }
        }
    }
}




