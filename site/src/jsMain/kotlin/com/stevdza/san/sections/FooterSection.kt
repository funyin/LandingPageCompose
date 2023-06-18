package com.stevdza.san.sections

import androidx.compose.runtime.Composable
import com.stevdza.san.components.SocialBar
import com.stevdza.san.models.Section
import com.stevdza.san.models.Theme
import com.stevdza.san.styles.NavigationItemStyle
import com.stevdza.san.util.Constants
import com.stevdza.san.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Col
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun FooterSection() {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px).padding(topBottom = 100.px).backgroundColor(Theme.LightGray.rgb),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 90.percent else 100.percent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(Res.Image.logo, modifier = Modifier.size(100.px))
            if (breakpoint > Breakpoint.SM)
                Row(horizontalArrangement = Arrangement.Center) {
                    FooterMenu(true)
                }
            else
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    FooterMenu(false)
                }
            Div(attrs = Modifier.padding(top = 20.px).toAttrs())
            SocialBar(true)
        }
    }
}

@Composable
fun FooterMenu(row:Boolean) {
    Section.values().take(6).forEach { section ->
        Link(
            path = section.path,
            section.title,
            modifier = NavigationItemStyle.toModifier().fontFamily(Constants.FONT_FAMILY).fontSize(12.px)
                .fontWeight(FontWeight.Normal)
                .thenIf(row,Modifier.margin(right = 20.px))
                .thenIf(!row,Modifier.margin(bottom = 8.px))
                .textDecorationLine(TextDecorationLine.None)
        )
    }
}
