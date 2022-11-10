package com.intercom.sample.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.intercom.android.sdk.UserAttributes

@Preview
@Composable
fun UserDetailsEditor(onUserDetailsSaved: (UserAttributes) -> Unit = {}) {
    val userStates = remember { mutableStateListOf(Attribute()) }

    Column {
        repeat(userStates.count()) { index ->
            Row {
                TextField(
                    value = userStates[index].key.value,
                    onValueChange = { userStates[index].key.value = it },
                    label = { Text(text = "key") },
                    modifier = Modifier.weight(0.35f),
                    singleLine = true
                )
                TextField(
                    value = userStates[index].value.value,
                    onValueChange = { userStates[index].value.value = it }, label = {
                        Text(text = "value")
                    },
                    modifier = Modifier.weight(0.65f),
                    singleLine = true,
                    trailingIcon = {
                        IconButton(
                            onClick = { userStates.remove(userStates[index]) },
                            content = {
                                Icon(
                                    imageVector = Icons.Outlined.Delete,
                                    contentDescription = "Delete row"
                                )
                            }
                        )
                    }
                )
            }
        }

        Row {
            Button(onClick = {
                userStates.add(Attribute())

            }) {
                Text(text = "Add attribute")
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Button(onClick = {
                val userAttributesBuilder = UserAttributes.Builder()
                userStates.forEach {

                    val customKey = it.key.value
                    val customValue = it.value.value
                    when (customKey) {
                        "name" -> userAttributesBuilder.withName(customValue)
                        "email" -> userAttributesBuilder.withEmail(customValue)
                        "phone" -> userAttributesBuilder.withPhone(customValue)
                        "user_id" -> userAttributesBuilder.withUserId(customValue)
                        else -> userAttributesBuilder.withCustomAttribute(customKey, customValue)
                    }
                }
                onUserDetailsSaved(userAttributesBuilder.build())

            }) {
                Text(text = "Save")
            }
        }
    }
}

data class Attribute(
    var key: MutableState<String> = mutableStateOf(""),
    var value: MutableState<String> = mutableStateOf("")
)
