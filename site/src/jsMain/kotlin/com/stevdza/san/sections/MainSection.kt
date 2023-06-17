package com.stevdza.san.sections

import androidx.compose.runtime.Composable
import com.stevdza.san.components.Header
import com.stevdza.san.components.SocialBar
import com.stevdza.san.models.Section
import com.stevdza.san.models.Theme
import com.stevdza.san.styles.MainButtonStyle
import com.stevdza.san.styles.MainImageStyle
import com.stevdza.san.util.Constants
import com.stevdza.san.util.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun MainSection() {
    Box(
        modifier = Modifier.id(Section.Home.id).maxWidth(Constants.SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        MainBackground()
        MainContent(breakpoint = rememberBreakpoint())
    }
}

@Composable
fun MainBackground() {
    Image(
        src = Res.Image.background,
        desc = "Background Image",
        modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover),
    )
}

@Composable
fun MainContent(breakpoint: Breakpoint) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Header()
        Column(
            modifier = Modifier.fillMaxWidth(if (breakpoint > Breakpoint.MD) 80.percent else 90.percent),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            SimpleGrid(
                modifier = Modifier.fillMaxWidth(),
                numColumns = numColumns(base = 1, md = 2)
            ) {
                MainText(breakpoint)
                MainImage()
            }
        }
    }
}

@Composable
fun MainText(breakpoint: Breakpoint) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint > Breakpoint.MD)
            SocialBar()
        Column {
            P(
                attrs = Modifier.margin(topBottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if (breakpoint > Breakpoint.MD) 45.px else 20.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text("Hello, I'm")
            }

            P(
                attrs = Modifier.margin(bottom = 0.px, top = 20.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(if (breakpoint > Breakpoint.MD) 68.px else 40.px)
                    .fontWeight(FontWeight.Bolder)
                    .lineHeight(1)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text("Funyinoluwa Kashimawo")
            }
            P(
                attrs = Modifier.margin(bottom = 5.px, top = 10.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text("Mobile Developer")
            }
            P(
                attrs = Modifier.margin(bottom = 25.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(15.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
                    .maxWidth(400.px)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(Constants.LOREM_IPSUM_SHORT)
            }

            Button(
                attrs = MainButtonStyle.toModifier()
                    .height(40.px)
                    .border(0.px)
                    .borderRadius(5.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .padding(0.px)
                    .toAttrs()
            ) {
                Link(
                    path = Section.Contact.path,
                    modifier = Modifier.color(Colors.White).textDecorationLine(TextDecorationLine.None)
                        .padding(leftRight = 12.px),
                    text = "Hire me"
                )
            }
        }
    }
}

@Composable
fun MainImage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(src = Res.Image.main, desc = "MainImage", modifier = MainImageStyle.toModifier().fillMaxWidth(80.percent))
    }
}
