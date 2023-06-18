package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.models.Testimonial
import com.stevdza.san.models.Theme
import com.stevdza.san.util.Constants
import com.stevdza.san.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun TestimonialCard(modifier: Modifier = Modifier, testimonial: Testimonial) {
    val breakpoint = rememberBreakpoint()
    Row(modifier = modifier) {
        Image(
            testimonial.image,
            modifier = Modifier.margin(right = 20.px).maxWidth(if (breakpoint > Breakpoint.MD) 160.px else 80.px)
                .borderRadius(topLeft = 60.px, topRight = 60.px, bottomLeft = 60.px)
        )
        Row(modifier = Modifier.fillMaxWidth().maxWidth(350.px)) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth().margin(bottom = 25.px)) {
                    Column(horizontalAlignment = Alignment.Start) {
                        P(
                            attrs = Modifier.margin(topBottom = 0.px)
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(18.px)
                                .fontWeight(FontWeight.Bold)
                                .color(Theme.Secondary.rgb)
                                .toAttrs()
                        ) {
                            Text(testimonial.fullName)
                        }
                        P(
                            attrs = Modifier.margin(topBottom = 0.px)
                                .fontFamily(Constants.FONT_FAMILY)
                                .fontSize(12.px)
                                .fontWeight(FontWeight.Normal)
                                .color(Theme.Secondary.rgb)
                                .toAttrs()
                        ) {
                            Text(testimonial.profession)
                        }
                        if (breakpoint < Breakpoint.MD)
                            RatingBar(modifier = Modifier.margin(top=8.px))
                    }
                    if (breakpoint >= Breakpoint.MD) {
                        Spacer()
                        RatingBar()
                    }
                }

                P(
                    attrs = Modifier.margin(topBottom = 0.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(12.px)
                        .fillMaxWidth()
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
                ) {
                    Text(testimonial.review)
                }
            }
        }
    }
}

@Composable
fun RatingBar(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        repeat(5) {
            Image(Res.Icon.star, modifier = Modifier.size(16.px).margin(right = if (it == 4) 0.px else 0.px))
        }
    }
}