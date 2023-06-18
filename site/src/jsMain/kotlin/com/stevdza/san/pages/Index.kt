package com.stevdza.san.pages

import androidx.compose.runtime.*
import com.stevdza.san.components.BackToTopButton
import com.stevdza.san.components.OverflowMenu
import com.stevdza.san.sections.*
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.pointerEvents
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Position

@Page
@Composable
fun HomePage() {
    var menuOpen by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainSection {
                menuOpen = true
            }
            AboutSection()
            ServicesSection()
            PortfolioSection()
            AchievementsSection()
            TestimonialSection()
            ExperienceSection()
            ContactSection()
            FooterSection()
        }
        Box(
            modifier = Modifier.fillMaxSize().zIndex(1).position(Position.Fixed)
                .pointerEvents(PointerEvents.None),
            contentAlignment = Alignment.BottomEnd
        ) {
            BackToTopButton(
                modifier = Modifier.zIndex(1)
                    .pointerEvents(PointerEvents.Auto),
            )
        }
        if (menuOpen)
            OverflowMenu {
                menuOpen = false
            }
    }
}