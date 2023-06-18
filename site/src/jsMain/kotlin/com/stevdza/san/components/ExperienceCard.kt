package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.models.Experience
import com.stevdza.san.models.Theme
import com.stevdza.san.util.Constants
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    active: Boolean = false,
    experience: Experience,
    detailsMargin: CSSSizeValue<CSSUnit.px>
) {
    val breakpoint = rememberBreakpoint()

    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2),
        modifier = Modifier.fillMaxWidth()
    ) {
        ExperienceDescription(active, experience)
        Row(
            modifier = Modifier.fillMaxWidth().margin(left = if (breakpoint >= Breakpoint.MD) 40.px else 0.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (breakpoint >= Breakpoint.MD)
                ExperienceNumber(active, experience)
            Column(
                modifier = Modifier.fillMaxSize().margin(left = detailsMargin)
                    .thenIf(breakpoint < Breakpoint.MD, Modifier.margin(left = 0.px, bottom = 20.px))
                    .transition(
                        CSSTransition(
                            property = "margin",
                            duration = 500.ms,
                            delay = experience.ordinal * 80.ms
                        )
                    ),
                verticalArrangement = Arrangement.Center
            ) {
                P(
                    attrs = Modifier.margin(topBottom = 0.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
                ) {
                    Text(experience.jobPosition)
                }

                P(
                    attrs = Modifier.margin(topBottom = 0.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
                ) {
                    Text("${experience.from} ${experience.to}")
                }
                P(
                    attrs = Modifier.margin(topBottom = 0.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontSize(14.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Primary.rgb)
                        .toAttrs()
                ) {
                    Text(experience.company)
                }
            }
        }
    }
}

@Composable
private fun ExperienceNumber(active: Boolean, experience: Experience) {
    Box(modifier = Modifier.fillMaxHeight().margin(right = 14.px), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier.fillMaxHeight().width(3.px).backgroundColor(Theme.Primary.rgb))
        Box(
            modifier = Modifier.size(40.px).borderRadius(50.percent).backgroundColor(
                if (active) Theme.Primary.rgb else Colors.White
            )
                .border(width = 3.px, style = LineStyle.Solid, color = Theme.Primary.rgb),
            contentAlignment = Alignment.Center
        ) {
            P(
                attrs = Modifier.margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Bold)
                    .color(if (active) Theme.LighterGray.rgb else Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(experience.number)
            }
        }
    }
}

@Composable
private fun ExperienceDescription(active: Boolean, experience: Experience) {
    Box(
        modifier = Modifier.margin(topBottom = 40.px).padding(14.px)
            .backgroundColor(if (active) Theme.Primary.rgb else Theme.LighterGray.rgb)
    ) {
        P(
            attrs = Modifier.margin(topBottom = 0.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(14.px)
                .lineHeight(1.6)
                .fontWeight(FontWeight.Normal)
                .color(if (active) Theme.LighterGray.rgb else Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(experience.description)
        }
    }
}