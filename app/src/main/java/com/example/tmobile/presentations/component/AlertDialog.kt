package com.example.tmobile.presentations.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmobile.R
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
@Preview
fun TAlertDialogPreview() {
    TAlertDialog()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TAlertDialog(
    showDialog: MutableStateFlow<Boolean> = remember { MutableStateFlow(false) },
    text: String = stringResource(R.string.something_went_wrong)
) {
    BasicAlertDialog(
        onDismissRequest = {
            showDialog.value = false
        }
    ) {
        Surface {
            Column(Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
                Spacer(Modifier.padding(10.dp))
                Text(
                    text = stringResource(R.string.whoops),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(Modifier.padding(10.dp))

                Text(
                    text = text,
                    fontSize = 14.sp
                )
                Spacer(Modifier.padding(10.dp))

                TextButton(
                    onClick = { showDialog.value = false },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(stringResource(R.string.ok))
                }
            }
        }
    }
}