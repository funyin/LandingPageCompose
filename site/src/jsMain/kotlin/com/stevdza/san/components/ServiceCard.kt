package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.models.Service
import com.stevdza.san.models.Theme
import com.stevdza.san.styles.AboutTextStyle
import com.stevdza.san.styles.ServiceCardStyle
import com.stevdza.san.util.Constants
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceCard(service: Service) {
    Column(
        modifier = ServiceCardStyle.toModifier().maxWidth(300.px).margin(20.px).padding(20.px)
            .border(width = 2.px, color = Theme.LighterGray.rgb, style = LineStyle.Solid)
    ) {
        Box(
            modifier = Modifier.padding(10.px).margin(bottom = 20.px)
                .id("iconBox")
                .borderRadius(topLeft = 20.px, topRight = 20.px, bottomLeft = 20.px)
                .border(width = 2.px, color = Theme.Primary.rgb, style = LineStyle.Solid)
        ) {
            Image(src = service.icon, desc = "Image desc", modifier = Modifier.size(40.px))
        }

        P(
            attrs = Modifier.margin(top = 0.px, bottom = 10.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ) {
            Text(service.title)
        }

        P(
            attrs = Modifier.margin(top = 0.px, bottom = 10.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(14.px)
                .toAttrs()
        ) {
            Text(service.description)
        }
    }
}