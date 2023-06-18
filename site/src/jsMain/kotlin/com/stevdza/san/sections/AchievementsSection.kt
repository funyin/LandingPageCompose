package com.stevdza.san.sections

import androidx.compose.runtime.*
import com.stevdza.san.components.AchievementCard
import com.stevdza.san.models.Achievement
import com.stevdza.san.models.Section
import com.stevdza.san.models.Theme
import com.stevdza.san.util.ObserveViewPortEntered
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px

@Composable
fun AchievementsSection() {
    val breakpoint = rememberBreakpoint()
    val achievements = Achievement.values()
    var viewportEntered by remember { mutableStateOf(false) }
    ObserveViewPortEntered(
        sectionId = Section.Achievements.id,
        distanceFromPort = 400.0,
        onViewPortEntered = {
            viewportEntered  = true
        }
    )
    Box(
        modifier = Modifier.id(Section.Achievements.id).padding(topBottom = 100.px)
            .backgroundColor(Theme.LighterGray.rgb).fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        SimpleGrid(
            numColumns = numColumns(base = 1, md = 2, lg = 4)
        ) {
            achievements.forEachIndexed { index, achievement ->
                val isLastIndex = index == achievements.lastIndex
                AchievementCard(
                    achievement = achievement, modifier = Modifier.thenIf(
                        breakpoint > Breakpoint.SM && !isLastIndex, Modifier.margin(right = 25.px)
                    ).thenIf(
                        breakpoint <= Breakpoint.MD && !isLastIndex && index != achievements.lastIndex - 1,
                        Modifier.margin(bottom = 25.px)
                    )
                )
            }
        }

    }
}