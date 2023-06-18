package com.stevdza.san.sections

import androidx.compose.runtime.Composable
import com.stevdza.san.components.PortfolioCard
import com.stevdza.san.components.SectionTitle
import com.stevdza.san.models.Portfolio
import com.stevdza.san.models.Section
import com.stevdza.san.styles.portfolioArrowIconStyle
import com.stevdza.san.util.Constants
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun PortfolioSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier.id(Section.Portfolio.id).maxWidth(Constants.SECTION_WIDTH.px).padding(topBottom = 100.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            SectionTitle(
                section = Section.Portfolio,
                modifier = Modifier.fillMaxWidth().padding(bottom = 25.px),
                alignment = Alignment.Start
            )
            Row(
                modifier = Modifier.fillMaxWidth().maxWidth(
                    if (breakpoint > Breakpoint.MD) 950.px
                    else if (breakpoint > Breakpoint.SM) 625.px
                    else 300.px
                )
                    .overflow(Overflow.Scroll)
                    .padding(bottom = 12.px)
                    .margin(bottom = 25.px)
                    .id("scrollableContainer")
            ) {
                Portfolio.values().forEachIndexed { index, portfolio: Portfolio ->
                    PortfolioCard(
                        modifier = Modifier.margin(
                            right =
                            if (index != Portfolio.values().lastIndex)
                                25.px else 0.px
                        ), portfolio = portfolio, link = ""
                    )
                }
            }
            PortfolioNavigation(onNavigateLeft = {
                document.getElementById("scrollableContainer")?.scrollBy(-325.0,0.0)
            }, onNavigateRight = {
                document.getElementById("scrollableContainer")?.scrollBy(325.0,0.0)
            })
        }
    }
}

@Composable
fun PortfolioNavigation(onNavigateLeft: () -> Unit, onNavigateRight: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        FaArrowLeft(
            modifier = portfolioArrowIconStyle.toModifier().cursor(Cursor.Pointer).onClick {
                onNavigateLeft()
            }.margin(right = 40.px),
            size = IconSize.LG
        )
        FaArrowRight(
            modifier = portfolioArrowIconStyle.toModifier().cursor(Cursor.Pointer).onClick {
                onNavigateRight()
            },
            size = IconSize.LG
        )
    }
}
