package com.stevdza.san.sections

import androidx.compose.runtime.*
import com.stevdza.san.components.ExperienceCard
import com.stevdza.san.components.SectionTitle
import com.stevdza.san.models.Experience
import com.stevdza.san.models.Section
import com.stevdza.san.util.Constants
import com.stevdza.san.util.ObserveViewPortEntered
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceSection() {
    val breakpoint = rememberBreakpoint()
    var animatedMargin by remember { mutableStateOf(300) }
    ObserveViewPortEntered(sectionId = Section.Experience.id, distanceFromPort = 500.0){
        animatedMargin = 50
    }
    Box(
        modifier = Modifier.id(Section.Experience.id).maxWidth(Constants.SECTION_WIDTH.px).padding(topBottom = 100.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 60.percent else 90.percent
            ),
            horizontalAlignment = Alignment.Start
        ) {
            SectionTitle(
                section = Section.Experience,
                modifier = Modifier.margin(bottom = 25.px),
                alignment = Alignment.Start
            )
            Experience.values().forEachIndexed { index, experience ->
                ExperienceCard(experience = experience, active = index == 0, detailsMargin = animatedMargin.px)
            }
        }
    }
}