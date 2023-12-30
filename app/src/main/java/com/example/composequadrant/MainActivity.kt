package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContentBody()
                }
            }
        }
    }
}

@Composable
fun ContentBody(modifier: Modifier = Modifier) {
    Column(modifier =  modifier) {
        Row(modifier = modifier.weight(weight = 0.5F)) {
            TextComposable(modifier = modifier)
        }
        Row(modifier = modifier.weight(weight = 0.5F)) {

        }
    }
}

@Composable
fun TextComposable(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.text_composable_title),
        modifier = modifier
    )
    Text(
        text = stringResource(id = R.string.text_composable_content)
    )
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ContentBody()
    }
}