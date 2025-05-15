package com.example.composefisrt.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 *项目名称：Compose Fisrt
 *包名： com.example.composefisrt.ui
 *作者： bobowg
 *日期： 2025/5/4 时间：22:56
 *备注：
 **/
@Preview
@Composable
fun AnimationScreen() {
    var isVisible by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 132.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Button(
            onClick = {
                isVisible = !isVisible

            }) {
            Text(
                text = "Click"
            )
        }
        Spacer(modifier = Modifier.height(59.dp))
        Column(
            modifier = Modifier
                .size(300.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(
                visible = isVisible,
                enter = scaleIn(),
                exit = scaleOut()
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Blue)
                        .animateContentSize()
                        .height(if (expanded) 400.dp else 100.dp)
                        .width(if (expanded) 400.dp else 100.dp)
                        .fillMaxWidth()
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            expanded = !expanded
                        }
                )
            }
        }
    }
}

@Preview
@Composable
private fun AnimatedVisibilityWithEnterAndExit() {
    var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            with(density) {
                -40.dp.roundToPx()
            }
        } + expandVertically(expandFrom = Alignment.Top) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ) {
        Column(
            modifier = Modifier
                .size(300.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Hello World",
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}

@Preview
@Composable
private fun AnimatedVisibilityMutable() {
    // [START android_compose_animations_animated_visibility_mutable]
    // Create a MutableTransitionState<Boolean> for the AnimatedVisibility.
    val state = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }
    Column {
        AnimatedVisibility(visibleState = state) {
            Text(text = "Hello, world!")
        }

        // Use the MutableTransitionState to know the current animation state
        // of the AnimatedVisibility.
        Text(
            text = when {
                state.isIdle && state.currentState -> "Visible"
                !state.isIdle && state.currentState -> "Disappearing"
                state.isIdle && !state.currentState -> "Invisible"
                else -> "Appearing"
            }
        )
    }
    // [END android_compose_animations_animated_visibility_mutable]
}

@Composable
@Preview
private fun AnimateAsStateSimple() {
    // [START android_compose_animations_animate_as_state]
    var enabled by remember { mutableStateOf(true) }

    val animatedAlpha: Float by animateFloatAsState(if (enabled) 1f else 0.5f, label = "alpha")
    Box(
        Modifier
            .fillMaxSize()
            .graphicsLayer { alpha = animatedAlpha }
            .background(Color.Red)
    )
    // [END android_compose_animations_animate_as_state]
    { Button(onClick = { enabled = !enabled }) { Text("Animate me!") } }
}

@Preview
@Composable
private fun AnimatedContentSimple() {
    // [START android_compose_animations_animated_content_simple]
    Row {
        var count by remember { mutableIntStateOf(0) }
        Button(onClick = { count++ }) {
            Text("Add")
        }
        AnimatedContent(
            targetState = count,
            label = "animated content"
        ) { targetCount ->
            // Make sure to use `targetCount`, not `count`.
            Text(text = "Count: $targetCount")
        }
    }
    // [END android_compose_animations_animated_content_simple]
}

