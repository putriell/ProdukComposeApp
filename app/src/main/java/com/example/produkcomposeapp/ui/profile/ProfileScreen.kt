package com.example.produkcomposeapp.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.produkcomposeapp.R
import com.example.produkcomposeapp.ui.theme.ProdukComposeAppTheme

@Composable
fun ProfileScreen (
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
    ) {
        item {
            ViewTopBar(modifier, onBackClick)
        }
        item {
            ProfileContent(modifier)
        }
    }
}

@Composable
fun ViewTopBar(modifier: Modifier, onBackClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            tint = Color.White,
            contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
                .clickable { onBackClick() }
        )
        Text(
            text = stringResource(R.string.profil),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }

}

@Composable
fun ProfileContent(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(R.drawable.me), contentDescription = null, modifier = Modifier
                .size(200.dp)
                .clip(
                    CircleShape
                ))

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Melani Putri Pratama", style = MaterialTheme.typography.h6)
            Text(text = "Putriell70@gmail.com", color = Color.Gray)
        }
    }

}


@Preview
@Composable
fun ProfileScreenPreview() {
    ProdukComposeAppTheme {
        ProfileScreen(onBackClick = { /*TODO*/ })
    }
}

