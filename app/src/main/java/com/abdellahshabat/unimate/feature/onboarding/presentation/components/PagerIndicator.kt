package com.abdellahshabat.unimate.feature.onboarding.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun PagerIndicator(pageCount: Int, currentPage: Int) {

    Row(horizontalArrangement = Arrangement.Center) {
        //repeat(pageCount) -> يعني:
        // لو عندنا 3 صفحات: سيصنع: ○ ○ ○
        //index == currentPage
        //إذا كانت الصفحة الحالية: ● ○ ○
        repeat(pageCount) { index ->

            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(
                        if (index == currentPage) 12.dp else 8.dp
                    )
                    .background(
                        color = if(index == currentPage)
                            androidx.compose.material3.MaterialTheme.colorScheme.primary
                        else
                            androidx.compose.material3.MaterialTheme.colorScheme.surfaceVariant,

                        shape = CircleShape
                    )
            )

        }

    }

}