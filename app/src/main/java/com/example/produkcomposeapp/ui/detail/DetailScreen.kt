package com.example.produkcomposeapp.ui.detail


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.produkcomposeapp.R
import com.example.produkcomposeapp.data.Repository
import com.example.produkcomposeapp.ui.ViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.produkcomposeapp.data.ListProduk
import com.example.produkcomposeapp.ui.main.MainScreen
import com.example.produkcomposeapp.ui.theme.ProdukComposeAppTheme

@Composable
fun DetailScreen (
    produkId: String,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(Repository())
    ),
    navigateBack: () -> Unit
) {

    val produk = viewModel.getProductById(produkId)

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item { TopBar(modifier, navigateBack) }
        item { DetailContent(produk = produk) }
    }
}



@Composable
fun DetailContent(produk: ListProduk, modifier: Modifier = Modifier) {

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 16.dp)
        ) {
            Box {
                AsyncImage(
                    model = produk.image,
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.placeholder_image),
                    contentDescription = null,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = produk.name,
                            style = MaterialTheme.typography.h6
                        )
                    }
                Text(
                    text = produk.description,
                    style = MaterialTheme.typography.body1,
                    lineHeight = 24.sp,
                )
            }
        }
    }
}


@Composable
fun TopBar(
    modifier: Modifier,
    onBackClick: () -> Unit
) {

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
            text = stringResource(R.string.produk_detail),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val produk = ListProduk("1",
        "Cleansing Pad",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        "https://i.pinimg.com/564x/2b/47/85/2b4785c49036f018427146129558c146.jpg"
    )
    ProdukComposeAppTheme {
        DetailContent(produk = produk)
    }
}


