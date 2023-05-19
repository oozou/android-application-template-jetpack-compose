package com.kbank.dafund.catalog.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kbank.dafund.core.designsystem.component.DafundButton
import com.kbank.dafund.core.designsystem.component.DafundFilterChip
import com.kbank.dafund.core.designsystem.component.DafundIconToggleButton
import com.kbank.dafund.core.designsystem.component.DafundLoadingWheel
import com.kbank.dafund.core.designsystem.component.DafundNavigationBar
import com.kbank.dafund.core.designsystem.component.DafundNavigationBarItem
import com.kbank.dafund.core.designsystem.component.DafundOutlinedButton
import com.kbank.dafund.core.designsystem.component.DafundOverlayLoadingWheel
import com.kbank.dafund.core.designsystem.component.DafundTab
import com.kbank.dafund.core.designsystem.component.DafundTabRow
import com.kbank.dafund.core.designsystem.component.DafundTextButton
import com.kbank.dafund.core.designsystem.component.DafundTopicTag
import com.kbank.dafund.core.designsystem.icon.DafundIcons
import com.kbank.dafund.core.designsystem.theme.DafundTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DafundCatalog() {
    DafundTheme {
        Surface {
            val contentPadding = WindowInsets
                .systemBars
                .add(WindowInsets(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp))
                .asPaddingValues()
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = contentPadding,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { Text(text = "Catalog", style = MaterialTheme.typography.headlineSmall) }
                item { Text("Text", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(text = "displayLarge", style = MaterialTheme.typography.displayLarge)
                        Text(text = "displayMedium", style = MaterialTheme.typography.displayMedium)
                        Text(text = "displaySmall", style = MaterialTheme.typography.displaySmall)
                        Text(text = "headlineLarge", style = MaterialTheme.typography.headlineLarge)
                        Text(text = "headlineMedium", style = MaterialTheme.typography.headlineMedium)
                        Text(text = "headlineSmall", style = MaterialTheme.typography.headlineSmall)
                        Text(text = "titleLarge", style = MaterialTheme.typography.titleLarge)
                        Text(text = "titleMedium", style = MaterialTheme.typography.titleMedium)
                        Text(text = "titleSmall", style = MaterialTheme.typography.titleSmall)
                        Text(text = "bodyLarge", style = MaterialTheme.typography.bodyLarge)
                        Text(text = "bodyMedium", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "bodySmall", style = MaterialTheme.typography.bodySmall)
                        Text(text = "labelLarge", style = MaterialTheme.typography.labelLarge)
                        Text(text = "labelMedium", style = MaterialTheme.typography.labelMedium)
                        Text(text = "labelSmall", style = MaterialTheme.typography.labelSmall)
                    }
                }
                item { Text("Buttons", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        DafundButton(onClick = {}) {
                            Text(text = "Enabled")
                        }
                        DafundOutlinedButton(onClick = {}) {
                            Text(text = "Enabled")
                        }
                        DafundTextButton(onClick = {}) {
                            Text(text = "Enabled")
                        }
                    }
                }
                item { Text("Disabled buttons", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        DafundButton(
                            onClick = {},
                            enabled = false
                        ) {
                            Text(text = "Disabled")
                        }
                        DafundOutlinedButton(
                            onClick = {},
                            enabled = false
                        ) {
                            Text(text = "Disabled")
                        }
                        DafundTextButton(
                            onClick = {},
                            enabled = false
                        ) {
                            Text(text = "Disabled")
                        }
                    }
                }
                item { Text("Buttons with leading icons", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        DafundButton(
                            onClick = {},
                            text = { Text(text = "Enabled") },
                            leadingIcon = {
                                Icon(imageVector = DafundIcons.Add, contentDescription = null)
                            }
                        )
                        DafundOutlinedButton(
                            onClick = {},
                            text = { Text(text = "Enabled") },
                            leadingIcon = {
                                Icon(imageVector = DafundIcons.Add, contentDescription = null)
                            }
                        )
                        DafundTextButton(
                            onClick = {},
                            text = { Text(text = "Enabled") },
                            leadingIcon = {
                                Icon(imageVector = DafundIcons.Add, contentDescription = null)
                            }
                        )
                    }
                }
                item { Text("Disabled buttons with leading icons", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        DafundButton(
                            onClick = {},
                            enabled = false,
                            text = { Text(text = "Disabled") },
                            leadingIcon = {
                                Icon(imageVector = DafundIcons.Add, contentDescription = null)
                            }
                        )
                        DafundOutlinedButton(
                            onClick = {},
                            enabled = false,
                            text = { Text(text = "Disabled") },
                            leadingIcon = {
                                Icon(imageVector = DafundIcons.Add, contentDescription = null)
                            }
                        )
                        DafundTextButton(
                            onClick = {},
                            enabled = false,
                            text = { Text(text = "Disabled") },
                            leadingIcon = {
                                Icon(imageVector = DafundIcons.Add, contentDescription = null)
                            }
                        )
                    }
                }
                item { Text("Dropdown menus", Modifier.padding(top = 16.dp)) }
                item { Text("Chips", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        var firstChecked by remember { mutableStateOf(false) }
                        DafundFilterChip(
                            selected = firstChecked,
                            onSelectedChange = { checked -> firstChecked = checked },
                            label = { Text(text = "Enabled") }
                        )
                        var secondChecked by remember { mutableStateOf(true) }
                        DafundFilterChip(
                            selected = secondChecked,
                            onSelectedChange = { checked -> secondChecked = checked },
                            label = { Text(text = "Enabled") }
                        )
                        DafundFilterChip(
                            selected = false,
                            onSelectedChange = {},
                            enabled = false,
                            label = { Text(text = "Disabled") }
                        )
                        DafundFilterChip(
                            selected = true,
                            onSelectedChange = {},
                            enabled = false,
                            label = { Text(text = "Disabled") }
                        )
                    }
                }
                item { Text("Icon buttons", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        var firstChecked by remember { mutableStateOf(false) }
                        DafundIconToggleButton(
                            checked = firstChecked,
                            onCheckedChange = { checked -> firstChecked = checked },
                            icon = {
                                Icon(
                                    painter = painterResource(id = DafundIcons.BookmarkBorder),
                                    contentDescription = null
                                )
                            },
                            checkedIcon = {
                                Icon(
                                    painter = painterResource(id = DafundIcons.Bookmark),
                                    contentDescription = null
                                )
                            }
                        )
                        var secondChecked by remember { mutableStateOf(true) }
                        DafundIconToggleButton(
                            checked = secondChecked,
                            onCheckedChange = { checked -> secondChecked = checked },
                            icon = {
                                Icon(
                                    painter = painterResource(id = DafundIcons.BookmarkBorder),
                                    contentDescription = null
                                )
                            },
                            checkedIcon = {
                                Icon(
                                    painter = painterResource(id = DafundIcons.Bookmark),
                                    contentDescription = null
                                )
                            }
                        )
                        DafundIconToggleButton(
                            checked = false,
                            onCheckedChange = {},
                            icon = {
                                Icon(
                                    painter = painterResource(id = DafundIcons.BookmarkBorder),
                                    contentDescription = null
                                )
                            },
                            checkedIcon = {
                                Icon(
                                    painter = painterResource(id = DafundIcons.Bookmark),
                                    contentDescription = null
                                )
                            },
                            enabled = false
                        )
                        DafundIconToggleButton(
                            checked = true,
                            onCheckedChange = {},
                            icon = {
                                Icon(
                                    painter = painterResource(id = DafundIcons.BookmarkBorder),
                                    contentDescription = null
                                )
                            },
                            checkedIcon = {
                                Icon(
                                    painter = painterResource(id = DafundIcons.Bookmark),
                                    contentDescription = null
                                )
                            },
                            enabled = false
                        )
                    }
                }
                item { Text("Tags", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        DafundTopicTag(
                            followed = true,
                            onClick = {},
                            text = { Text(text = "Topic 1".uppercase()) }
                        )
                        DafundTopicTag(
                            followed = false,
                            onClick = {},
                            text = { Text(text = "Topic 2".uppercase()) }
                        )
                        DafundTopicTag(
                            followed = false,
                            onClick = {},
                            text = { Text(text = "Disabled".uppercase()) },
                            enabled = false
                        )
                    }
                }
                item { Text("Tabs", Modifier.padding(top = 16.dp)) }
                item {
                    var selectedTabIndex by remember { mutableStateOf(0) }
                    val titles = listOf("Topics", "People")
                    DafundTabRow(selectedTabIndex = selectedTabIndex) {
                        titles.forEachIndexed { index, title ->
                            DafundTab(
                                selected = selectedTabIndex == index,
                                onClick = { selectedTabIndex = index },
                                text = { Text(text = title) }
                            )
                        }
                    }
                }
                item { Text("Navigation", Modifier.padding(top = 16.dp)) }
                item {
                    var selectedItem by remember { mutableStateOf(0) }
                    val items = listOf("For you", "Episodes", "Saved", "Interests")
                    val icons = listOf(
                        DafundIcons.UpcomingBorder,
                        DafundIcons.MenuBookBorder,
                        DafundIcons.BookmarksBorder
                    )
                    val selectedIcons = listOf(
                        DafundIcons.Upcoming,
                        DafundIcons.MenuBook,
                        DafundIcons.Bookmarks
                    )
                    val tagIcon = DafundIcons.Tag
                    DafundNavigationBar {
                        items.forEachIndexed { index, item ->
                            DafundNavigationBarItem(
                                icon = {
                                    if (index == 3) {
                                        Icon(imageVector = tagIcon, contentDescription = null)
                                    } else {
                                        Icon(
                                            painter = painterResource(id = icons[index]),
                                            contentDescription = item
                                        )
                                    }
                                },
                                selectedIcon = {
                                    if (index == 3) {
                                        Icon(imageVector = tagIcon, contentDescription = null)
                                    } else {
                                        Icon(
                                            painter = painterResource(id = selectedIcons[index]),
                                            contentDescription = item
                                        )
                                    }
                                },
                                label = { Text(item) },
                                selected = selectedItem == index,
                                onClick = { selectedItem = index }
                            )
                        }
                    }
                }
                item { Text("Loading", Modifier.padding(top = 16.dp)) }
                item {
                    Row {
                        DafundLoadingWheel(contentDesc = "Loading")
                        Spacer(modifier = Modifier.width(20.dp))
                        DafundOverlayLoadingWheel(contentDesc = "Loading")
                    }
                }
            }
        }
    }
}
