package com.abdellahshabat.unimate.feature.onboarding.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//OnBoardingScreen لأن الـ Navigation لا يستطيع الانتقال إلى شاشة غير موجودة.

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.abdellahshabat.unimate.core.datastore.PreferenceRepository
import com.abdellahshabat.unimate.core.navigation.Routes
import com.abdellahshabat.unimate.feature.onboarding.model.onBoardingPages
import com.abdellahshabat.unimate.feature.onboarding.presentation.components.PagerIndicator
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavController) {

    //pagerState
    //يحفظ: الصفحة الحالية.عدد الصفحات.حالة السحب.
    //مثلاً: Page 0 Page 1 Page 2
    val pagerState = rememberPagerState(
        pageCount = {
            onBoardingPages.size
        }
    )
    val context = LocalContext.current

    val repository = PreferenceRepository(context)

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //المستخدم يسحب يمين ويسار.Instagram Stories
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            //page
            //يمثل رقم الصفحة الحالية. مثلاً: page = 0 يعرض: Welcome to UniMate AI

            Column(

                modifier = Modifier.fillMaxSize(),

                horizontalAlignment = Alignment.CenterHorizontally,

                verticalArrangement = Arrangement.Center

            ) {


                Image(

                    painter = painterResource(
                        id = onBoardingPages[page].imageRes
                    ),

                    contentDescription = null,

                    modifier = Modifier.size(220.dp)

                )


                Spacer(modifier = Modifier.height(40.dp))


                Text(

                    text = onBoardingPages[page].title,

                    style = MaterialTheme.typography.headlineMedium

                )


                Spacer(modifier = Modifier.height(16.dp))


                Text(
                    text = onBoardingPages[page].description,

                    style = MaterialTheme.typography.bodyLarge

                )
            }
        }
        PagerIndicator(
            pageCount = onBoardingPages.size,
            currentPage = pagerState.currentPage
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            scope.launch {

                if (pagerState.currentPage == onBoardingPages.lastIndex) {

                    repository.saveOnBoardingState()

                    navController.navigate(Routes.Login) {

                        popUpTo(navController.graph.findStartDestination().id)

                        launchSingleTop = true

                    }

                } else {

                    pagerState.animateScrollToPage(
                        pagerState.currentPage + 1
                    )

                }

            }

        }) {
            Text(

                if(pagerState.currentPage == onBoardingPages.lastIndex)
                    "Get Started"
                else
                    "Next"

            )
        }

    }
}