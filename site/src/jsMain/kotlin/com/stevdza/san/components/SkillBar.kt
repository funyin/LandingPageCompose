package com.stevdza.san.components

import androidx.compose.runtime.*
import com.stevdza.san.models.Theme
import com.stevdza.san.util.Constants
import com.stevdza.san.util.animatePercentage
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillBar(
    name: String,
    index: Int,
    percent: CSSSizeValue<CSSUnit.percent> = 50.percent
) {
    var animatedPercent by remember { mutableStateOf(percent.value) }
    val scope = rememberCoroutineScope()
    LaunchedEffect(percent) {
        scope.launch {
            animatePercentage(percent = percent.value, delay = (index + 1) * 8L) {
                animatedPercent = it.toFloat()
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth().maxWidth(700.px).margin(bottom = 10.px)
            .padding(topBottom = 5.px)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().margin(bottom = 5.px),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            P(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontWeight(FontWeight.Normal)
                    .fontSize(18.px)
                    .margin(topBottom = 0.px)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(name)
            }
            P(
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontWeight(FontWeight.Normal)
                    .fontSize(18.px)
                    .margin(topBottom = 0.px)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text("$animatedPercent%")
            }
        }

        Box(
            modifier = Modifier.fillMaxWidth().height(5.px).backgroundColor(Theme.LightGray.rgb)
                .borderRadius(topRight = 2.px, bottomRight = 2.px)
        ) {
            Box(
                modifier = Modifier.backgroundColor(Theme.Primary.rgb).fillMaxHeight().fillMaxWidth(percent)
                    .borderRadius(topRight = 2.px, bottomRight = 2.px)
                    .transition(CSSTransition(property = "width", duration = index * 300.ms))
            )
        }
    }
}