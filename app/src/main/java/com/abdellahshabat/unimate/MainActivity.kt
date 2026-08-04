package com.abdellahshabat.unimate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abdellahshabat.unimate.core.navigation.NavGraph
import com.abdellahshabat.unimate.ui.theme.UniMateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //ما هي setContent؟
        //هذا من أهم المفاهيم في Compose.
        //أي:
        //"اعرض Composable."
        //داخلها نستدعي أي شاشة نريدها.
        setContent {
            UniMateTheme {
                NavGraph()
                //بدل أن تعرض MainActivity شاشة واحدة مباشرة وهي الصبلش ، ستعرض NavGraph.
                //وNavGraph هو الذي سيقرر أي شاشة تظهر.
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UniMateTheme {
        Greeting("Android")
    }
}