package com.example.foodordering.Activity.Dashboard

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodordering.Activity.BaseActivity
import com.example.foodordering.ui.theme.FoodOrderingTheme

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    val scaffoldState = rememberScaffoldState()
    Scaffold (
        bottomBar = { MyBottomBar() },
        scaffoldState = scaffoldState
    ){paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues).fillMaxSize()
        ) {

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewMain(){
//    FoodOrderingTheme {
//        MainScreen()
//    }
//}