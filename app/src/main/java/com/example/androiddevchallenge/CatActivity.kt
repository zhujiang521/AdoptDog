package com.example.androiddevchallenge

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class CatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.getStringExtra(NAME) ?: ""
        val photo = intent.getIntExtra(PHOTO, 0)
        setContent {
            MyTheme {
                Cat(this, name, photo)
            }
        }
    }

    companion object {
        const val NAME = "name"
        const val PHOTO = "photo"
    }
}

// Start building your app here!
@Composable
fun Cat(context: Context, name: String, photo: Int) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                //列表内容
                Image(
                    painter = painterResource(id = photo),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Dog name：${name}", modifier = Modifier
                        .padding(20.dp)
                )
                Button(modifier = Modifier
                    .padding(20.dp), onClick = {
                    Toast
                        .makeText(
                            context,
                            "Congratulations on your successful adoption : $name !",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }) {

                }

            })
    }
}