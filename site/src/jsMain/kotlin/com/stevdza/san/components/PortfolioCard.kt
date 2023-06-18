package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.models.Portfolio
import com.stevdza.san.models.Theme
import com.stevdza.san.styles.PorfolioCardStyle
import com.stevdza.san.util.Constants
import com.stevdza.san.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PortfolioCard(modifier: Modifier = Modifier, portfolio: Portfolio, link: String) {
    Link(
        path = link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
        modifier = PorfolioCardStyle.toModifier().then(modifier).minWidth(300.px).textDecorationLine(textDecorationLine = TextDecorationLine.None)
    ) {
        Column(modifier = Modifier.id("columnParent")) {
            Box(modifier = Modifier.margin(bottom = 20.px).size(300.px).id("boxParent")) {
                Image(
                    modifier = Modifier.size(300.px).margin(bottom = 20.px).objectFit(ObjectFit.Cover),
                    src = portfolio.image,
                    desc = "Portfolio Image"
                )
                Box(
                    modifier = Modifier.fillMaxHeight().id("greenOverlay")
                        .backgroundColor(rgba(r = 0, g = 167, b = 142, a = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(src = Res.Icon.link, modifier = Modifier.size(32.px).id("linkIcon"))
                }
            }
            P(
                attrs = Modifier.margin(topBottom = 0.px).margin()
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(portfolio.title)
            }
            P(
                attrs = Modifier.margin(topBottom = 0.px).margin(top = 8.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .opacity(50.percent)
                    .toAttrs()
            ) {
                Text(portfolio.description)
            }
        }
    }
}