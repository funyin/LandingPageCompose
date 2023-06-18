package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.models.Section
import com.stevdza.san.models.Theme
import com.stevdza.san.util.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    alignment: Alignment.Horizontal = Alignment.CenterHorizontally
) {
    val textAlign = when (alignment) {
        Alignment.CenterHorizontally -> TextAlign.Center
        Alignment.End -> TextAlign.End
        Alignment.Start -> TextAlign.Start
    }
    Column(
        modifier = modifier,
        horizontalAlignment = alignment
    ) {
        P(
            attrs = Modifier.fillMaxWidth()
                .fontFamily(Constants.FONT_FAMILY).fontWeight(FontWeight.Normal).margin(topBottom = 0.px)
                .fontSize(25.px)
                .color(Theme.Primary.rgb)
                .textAlign(
                    textAlign
                )
                .color(Theme.Primary.rgb).toAttrs()
        ) {
            Text(section.title)
        }

        P(
            attrs = Modifier.fillMaxWidth()
                .fontFamily(Constants.FONT_FAMILY).fontWeight(FontWeight.Bold).margin(bottom = 10.px, top = 0.px)
                .fontSize(40.px)
                .textAlign(textAlign)
                .color(Theme.Secondary.rgb).toAttrs()
        ) {
            Text(section.subtitle)
        }

        Box(modifier = Modifier.height(2.px).width(80.px).borderRadius(50.px).backgroundColor(Theme.Primary.rgb))
    }
}