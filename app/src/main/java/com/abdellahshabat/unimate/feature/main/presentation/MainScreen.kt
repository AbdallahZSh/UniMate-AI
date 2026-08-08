package com.abdellahshabat.unimate.feature.main.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

//الـ MainScreen هو المسؤول عن Bottom Navigation:
@Composable
fun MainScreen() {

    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    val items = listOf(
        "Home",
        "Courses",
        "AI",
        "Profile"
    )

    Scaffold(

        bottomBar = {

            NavigationBar {

                items.forEachIndexed { index, item ->

                    NavigationBarItem(

                        selected = selectedItem == index,

                        onClick = {
                            selectedItem = index
                        },

                        icon = {

                            when (index) {

                                0 -> Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = "Home"
                                )

                                1 -> Icon(
                                    imageVector = Icons.Default.School,
                                    contentDescription = "Courses"
                                )

                                2 -> Icon(
                                    imageVector = Icons.Default.SmartToy,
                                    contentDescription = "AI"
                                )

                                3 -> Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Profile"
                                )

                            }

                        },

                        label = {
                            Text(item)
                        }

                    )

                }

            }

        }

    ) { paddingValues ->

        androidx.compose.foundation.layout.Box(
            modifier = androidx.compose.ui.Modifier
                .padding(paddingValues)
        ) {

            when (selectedItem) {

                0 -> HomeScreen()

                1 -> CoursesScreen()

                2 -> AiScreen()

                3 -> ProfileScreen()

            }

        }

    }

}