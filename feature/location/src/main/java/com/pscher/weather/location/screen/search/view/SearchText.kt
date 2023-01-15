package com.pscher.weather.location.screen.search.view

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscher.weather.ui.uikit.AppThemeParam
import com.pscher.weather.resource.common.R as CommonR

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchText(
    modifier: Modifier = Modifier,
    search: String?,
    enabled: Boolean,
    onSearch: (String?) -> Unit,
) {

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val focusModifier = Modifier.focusTarget()
    var isFilterFocused by remember { mutableStateOf(false) }

    val value = search ?: ""

    Row(
        modifier = modifier
            .background(
                color = AppThemeParam.colors.primary,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        BasicTextField(
            modifier = focusModifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .padding(start = 6.dp)
                .focusRequester(focusRequester)
                .onFocusChanged { focusState ->
                    isFilterFocused = focusState.isFocused
                },
            value = value,
            onValueChange = { onSearch(it) },
            enabled = enabled,
            textStyle = AppThemeParam.typography.paragraph01.copy(color = AppThemeParam.colors.text),
            cursorBrush = SolidColor(AppThemeParam.colors.text),
            decorationBox = @Composable { innerTextField ->
                // places leading icon, text field with label and placeholder, trailing icon
                TextFieldDefaults.TextFieldDecorationBox(
                    value = value,
                    visualTransformation = VisualTransformation.None,
                    innerTextField = innerTextField,
                    placeholder = {
                        Text(
                            text = "Город/населённый пункт",
                            style = AppThemeParam.typography.paragraph01,
                            color = AppThemeParam.colors.textHint,
                        )
                    },
                    singleLine = true,
                    enabled = enabled,
                    interactionSource = remember { MutableInteractionSource() },
                    //Устанавливаем необходимые отступы, дефолтные слишком большие
                    contentPadding = PaddingValues(
                        start = 0.dp,
                        top = 0.dp,
                        end = 0.dp,
                        bottom = 0.dp
                    )
                )
            }
        )

        if (!value.isNullOrEmpty()) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 6.dp)
                    .size(32.dp),
                onClick = {
                    onSearch(null)
                    focusManager.clearFocus()
                },
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(CommonR.drawable.ic_cross),
                    contentDescription = "Clear search text",
                    tint= Color.Unspecified,
                )
            }
        }

    }
}

@Preview
@Composable
private fun testSearchText() {
    MaterialTheme(
        colors = lightColors(
            background = AppThemeParam.colors.primary,
            surface = AppThemeParam.colors.primary,
        )
    ) {
        Surface() {
            SearchText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                search = "Пск",
                enabled = true,
                onSearch = {},
            )
        }
    }
}

@Preview
@Composable
private fun testSearchTextEmpty() {
    MaterialTheme(
        colors = lightColors(
            background = AppThemeParam.colors.primary,
            surface = AppThemeParam.colors.primary,
        )
    ) {
        Surface() {
            SearchText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                search = null,
                enabled = false,
                onSearch = {},
            )
        }
    }
}