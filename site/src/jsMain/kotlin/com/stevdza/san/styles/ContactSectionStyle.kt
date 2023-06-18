package com.stevdza.san.styles

import com.stevdza.san.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.focus
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val InputStyle by ComponentStyle {
    base {
        Modifier
            .border(width = 2.px, color = Theme.LightGray.rgb, style = LineStyle.Solid)
            .borderColor(Theme.LightGray.rgb)
            .transition(CSSTransition(property = "border", duration = 200.ms))
    }
    focus {
        Modifier.borderColor(Theme.Primary.rgb)
            .boxShadow(offsetX = 0.px, offsetY = 0.px, spreadRadius = 0.px, color = null)
    }
    hover {
        Modifier.borderColor(Theme.Primary.rgb)
            .boxShadow(offsetX = 0.px, offsetY = 0.px, spreadRadius = 0.px, color = null)
    }
}