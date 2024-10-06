package com.example.quadrantcompose

import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Import the theme
import com.example.quadrantcompose.ui.theme.QuadrantComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuadrantScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun QuadrantScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background), // Use MaterialTheme colors
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                title = "Text composable",
                descriptor = "Displays text and follows recommended material Design guidelines.",
                backgroundColor = Color(0xFFEADDDFF),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = "Image composable",
                descriptor = "Creates a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                title = "Row composable",
                descriptor = "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = "Column composable",
                descriptor = "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(
    title: String,
    descriptor: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(backgroundColor, shape = RoundedCornerShape(8.dp)), // Add rounded corners
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = descriptor,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuadrantComposeTheme {
        QuadrantScreen()
    }
}