package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    /**
     * Columns and rows have to be included explicitly here because Modifier.weight
     * requires a Row or Column to be within a ColumnScope or a RowScope, respectively,
     * in order for the height/width to be calculated correctly.
     */
    Column(modifier =  modifier.fillMaxHeight()) {
        Row(modifier = modifier.weight(weight = 0.5F)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .background(colorResource(id = R.color.text_composable))
                    .fillMaxSize()
                    .padding(16.dp)
                    .weight(weight = 0.5F),
                verticalArrangement = Arrangement.Center,
            ) {
                Quadrant(
                    content = stringResource(id = R.string.text_composable_content),
                    modifier = modifier,
                    title = stringResource(id = R.string.text_composable_title),
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .background(colorResource(id = R.color.image_composable))
                    .fillMaxSize()
                    .padding(16.dp)
                    .weight(weight = 0.5F),
                verticalArrangement = Arrangement.Center,
            ) {
                Quadrant(
                    content = stringResource(id = R.string.image_composable_content),
                    modifier = modifier,
                    title = stringResource(id = R.string.image_composable_title),
                )
            }
        }
        Row(modifier = modifier.weight(weight = 0.5F)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .background(colorResource(id = R.color.row_composable))
                    .fillMaxSize()
                    .padding(16.dp)
                    .weight(weight = 0.5F),
                verticalArrangement = Arrangement.Center,
            ) {
                Quadrant(
                    content = stringResource(id = R.string.row_composable_content),
                    modifier = modifier,
                    title = stringResource(id = R.string.row_composable_title),
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .background(colorResource(id = R.color.column_composable))
                    .fillMaxSize()
                    .padding(16.dp)
                    .weight(weight = 0.5F),
                verticalArrangement = Arrangement.Center,
            ) {
                Quadrant(
                    content = stringResource(id = R.string.column_composable_content),
                    modifier = modifier,
                    title = stringResource(id = R.string.column_composable_title),
                )
            }
        }
    }
}


@Composable
fun Quadrant(content: String, modifier: Modifier = Modifier, title: String) {
        Text(
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 16.dp),
            text = title,
        )
        Text(
            modifier = modifier,
            text = content,
            textAlign = TextAlign.Justify,
        )
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ContentBody()
    }
}