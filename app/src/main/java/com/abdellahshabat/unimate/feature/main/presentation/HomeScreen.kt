package com.abdellahshabat.unimate.feature.main.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(
    onCoursesClick: () -> Unit = {},
    onTasksClick: () -> Unit = {},
    onAiClick: () -> Unit = {},
    onNotesClick: () -> Unit = {},
    onQuizClick: () -> Unit = {}
) {
    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),

        contentPadding = PaddingValues(
            top = 24.dp,
            bottom = 24.dp
        ),

        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {

        item {

            Text(
                text = "Welcome back 👋",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "What do you want to do today?",
                style = MaterialTheme.typography.bodyLarge
            )
        }


        // AI Assistant

        item {

            Card(

                modifier = Modifier
                    .fillMaxWidth(),

                shape = RoundedCornerShape(20.dp),

                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.primaryContainer
                )

            ) {

                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),

                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Icon(
                        imageVector = Icons.Default.AutoAwesome,
                        contentDescription = "AI Assistant"
                    )

                    Spacer(
                        modifier = Modifier.padding(8.dp)
                    )

                    Column {

                        Text(
                            text = "AI Assistant",
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = "Ask UniMate anything",
                            style = MaterialTheme.typography.bodyMedium
                        )

                    }

                }

            }

        }


        // Courses + Tasks

        item {

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(12.dp)

            ) {

                DashboardCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.MenuBook,
                    title = "Courses",
                    value = "0",
                    onClick = onCoursesClick
                )

                DashboardCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.CheckCircle,
                    title = "Tasks",
                    value = "0",
                    onClick = onTasksClick
                )

            }

        }


        // Upcoming

        item {

            Text(
                text = "Upcoming",
                style = MaterialTheme.typography.titleLarge
            )

        }


        item {

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "No upcoming tasks",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Text(
                        text = "You're all caught up!",
                        style = MaterialTheme.typography.bodyMedium
                    )

                }

            }

        }


        // Quick Actions

        item {

            Text(
                text = "Quick Actions",
                style = MaterialTheme.typography.titleLarge
            )

        }


        item {

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.spacedBy(12.dp)

            ) {

                QuickAction(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Note,
                    title = "Notes",
                    onClick = onNotesClick
                )

                QuickAction(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Quiz,
                    title = "Quiz",
                    onClick = onQuizClick
                )

                QuickAction(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.AutoAwesome,
                    title = "AI",
                    onClick = onAiClick
                )

            }

        }

    }

}@Composable
private fun DashboardCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    value: String,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        onClick = onClick
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Icon(
                imageVector = icon,
                contentDescription = title
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}

@Composable
private fun QuickAction(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        onClick = onClick
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = icon,
                contentDescription = title
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}