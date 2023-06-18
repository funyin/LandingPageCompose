package com.stevdza.san.sections

import androidx.compose.runtime.*
import com.stevdza.san.components.SectionTitle
import com.stevdza.san.components.SkillBar
import com.stevdza.san.models.Section
import com.stevdza.san.models.Skill
import com.stevdza.san.models.Theme
import com.stevdza.san.styles.AboutImageStyle
import com.stevdza.san.styles.AboutTextStyle
import com.stevdza.san.util.Constants
import com.stevdza.san.util.ObserveViewPortEntered
import com.stevdza.san.util.Res
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection() {
    var viewPortEntered by remember { mutableStateOf(false) }
    ObserveViewPortEntered(Section.About.id, 400.0) {
        viewPortEntered = true
    }
    Box(
        modifier = Modifier.id(Section.About.id).maxWidth(Constants.SECTION_WIDTH.px).padding(topBottom = 150.px),
        contentAlignment = Alignment.TopCenter
    ) {
        val breakPoint = rememberBreakpoint()
        Column(
            modifier = Modifier.fillMaxWidth(
                if (breakPoint >= Breakpoint.MD) 100.percent else 80.percent
            )
                .maxWidth(1200.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleGrid(numColumns = numColumns(base = 1, md = 2)) {
                if (breakPoint >= Breakpoint.MD)
                    Box(
                        modifier = Modifier.fillMaxWidth(
                            if (breakPoint >= Breakpoint.MD) 90.percent else 100.percent
                        ), contentAlignment = Alignment.Center
                    ) {
                        Image(
                            src = Res.Image.about,
                            "About image",
                            modifier = AboutImageStyle.toModifier().fillMaxWidth(80.percent)
                        )
                    }
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    SectionTitle(section = Section.About, alignment = Alignment.Start)
                    P(
                        attrs = AboutTextStyle.toModifier().margin(topBottom = 25.px)
                            .fontFamily(Constants.FONT_FAMILY)
                            .maxWidth(500.px)
                            .fontSize(18.px)
                            .fontStyle(FontStyle.Italic)
                            .color(Theme.Secondary.rgb)
                            .toAttrs()
                    ) {
                        Text(Constants.LOREM_IPSUM_SHORT)
                    }

                    Skill.values().forEach { skill ->
                        SkillBar(skill.title, skill.ordinal, if (viewPortEntered) skill.percentage else 0.percent)
                    }
                }
            }
        }
    }
}
