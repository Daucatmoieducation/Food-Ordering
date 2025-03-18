package com.example.foodordering.Activity.Splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodordering.Activity.BaseActivity
import com.example.foodordering.Activity.Dashboard.MainActivity
import com.example.foodordering.R


class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen(onGetStartedClick = {
                startActivity(Intent(this, MainActivity::class.java))
            })
        }
    }
}
@Preview
@Composable
fun SplashScreen(onGetStartedClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.darkBrown))
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(top = 48.dp)
        ) {
            val (backgroundImg, loginImg) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.intro_pic),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(backgroundImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(R.drawable.pizza),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(loginImg) {
                        top.linkTo(backgroundImg.top)
                        bottom.linkTo(backgroundImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Fit
            )
        }

        val styledText = buildAnnotatedString {
            append("Welcome to your ")
            withStyle(style = SpanStyle(color = colorResource(R.color.orange))) {
                append("food\nparadis ")
            }
            append(" experience food perfection delivered")
        }

        Text(
            text = styledText,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(top = 32.dp)
                .padding(horizontal = 16.dp)
                .wrapContentHeight()
        )

        Text(
            text = stringResource(R.string.splashSubtitle),
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        GetStartedButton(
            onClick = onGetStartedClick,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
