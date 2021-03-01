/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(this)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(context: Context) {
    val catList = arrayListOf<Cat>()
    catList.apply {
        add(Cat("Jack", R.drawable.dog0))
        add(Cat("Danny", R.drawable.dog1))
        add(Cat("Lucy", R.drawable.dog2))
        add(Cat("Make", R.drawable.dog3))
        add(Cat("Zhu", R.drawable.dog4))
        add(Cat("Juu", R.drawable.dog5))
        add(Cat("Tue", R.drawable.dog6))
        add(Cat("Jia", R.drawable.dog7))
        add(Cat("Cake", R.drawable.dog8))
        add(Cat("Luci", R.drawable.dog9))
    }
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(content = {
            items(catList) { item ->
                //列表内容
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable {
                            val intent = Intent(context, CatActivity::class.java)
                            intent.putExtra(CatActivity.NAME, item.name)
                            intent.putExtra(CatActivity.PHOTO, item.photo)
                            context.startActivity(intent)
                        },
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = item.photo),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(text = "Dog name：${item.name}")
                }
            }
        })
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        //MyApp()
    }
}
