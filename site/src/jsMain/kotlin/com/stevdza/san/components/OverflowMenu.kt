package com.stevdza.san.components

import androidx.compose.runtime.*
import com.stevdza.san.models.Section
import com.stevdza.san.styles.NavigationItemStyle
import com.stevdza.san.util.Constants
import com.stevdza.san.util.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaX
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Section

@Composable
fun OverflowMenu(onMenuClose: () -> Unit) {
    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    var translatex by remember { mutableStateOf(-100.percent) }
    var opacity by remember { mutableStateOf(0.percent) }

    val closeMenu = {
        scope.launch {
            translatex = (-100).percent
            opacity = 0.percent
            delay(500)
            onMenuClose()
        }
    }
    LaunchedEffect(breakpoint) {
        scope.launch {
            translatex = 0.percent
            opacity = 100.percent
        }
        if (breakpoint > Breakpoint.MD)
            closeMenu()
    }

    Column(
        modifier = Modifier.fillMaxWidth()
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(2)
            .opacity(opacity)
            .backgroundColor(argb(a = 0.5f, r = 0.0f, g = 0.0f, b = 0.0f))
            .transition(CSSTransition(property = "opacity", duration = 500.ms))
    ) {
        Column(
            modifier = Modifier.padding(25.px).fillMaxHeight().width(
                if (breakpoint >= Breakpoint.MD) 25.percent else 50.percent
            ).backgroundColor(Colors.White)
                .translateX(translatex)
                .transition(CSSTransition(property = "translate", duration = 500.ms))
                .overflow(Overflow.Auto)
                .scrollBehavior(ScrollBehavior.Smooth)
        ) {
            Row(modifier = Modifier.margin(bottom = 25.px), verticalAlignment = Alignment.CenterVertically) {
                FaXmark(
                    modifier = Modifier.color(Colors.Black).cursor(Cursor.Pointer).margin(right = 20.px, bottom = 3.px)
                        .onClick {
                            closeMenu()
                        },
                    size = IconSize.LG
                )
                Image(src = Res.Image.logo, modifier = Modifier.size(80.px), desc = "Logo Image")
            }

            Section.values().take(6).forEach { section ->
                Link(
                    path = section.path,
                    modifier = NavigationItemStyle.toModifier().fillMaxWidth().fontSize(16.px)
                        .fontFamily(Constants.FONT_FAMILY)
                        .margin(bottom = 10.px).textDecorationLine(TextDecorationLine.None).onClick {
                            closeMenu()
                        },
                    openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    text = section.title
                )
            }
        }
    }
}