package com.example.code_picker.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hs.code_picker.R

data class Country(val name: String, val code: String, val flag: Int)

@Composable
fun countries() = listOf(

    Country(stringResource(id = R.string.afghanistan), "+93",R.drawable.flag_of_afghanistan ),
    Country(stringResource(id = R.string.albania), "+355",  R.drawable.flag_of_albania),
    Country(stringResource(id = R.string.algeria), "+213", R.drawable.flag_of_algeria),
    Country(stringResource(id = R.string.andorra), "+376", R.drawable.flag_of_andorra),
    Country(stringResource(id = R.string.antarctica), "+672", R.drawable.flag_of_antarctica),
    Country(stringResource(id = R.string.antigua_and_barbuda), "+672", R.drawable.flag_of_antigua_and_barbuda),
)

@Composable
private fun CountryItem(
    country: Country,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier.clickable(onClick = onItemClick)
    )
    {
        Image(
            painter = painterResource(id = country.flag),
            contentDescription = country.name,
            modifier = Modifier
                .size(30.dp)
                .padding(end = 8.dp),
            alignment = Alignment.Center
        )
        Text(
            text = country.name,
//            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Start
        )
        Text(
            text = "+${country.code}",
//            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Start
        )
    }


}

@Composable
fun CountryCodePicker(
    countries: List<Country>,
    onCountrySelected: (Country) -> Unit
) {
    Column(Modifier.fillMaxWidth()) {
        countries.forEachIndexed { index, country ->
            CountryItem(country = country) {
                onCountrySelected(country)
            }
            if (index < countries.size - 1) {
                Divider()
            }
        }
    }
}