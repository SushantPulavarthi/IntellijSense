package org.intellijsense.intellijsense

import com.intellij.codeInsight.inline.completion.InlineCompletionElement
import com.intellij.codeInsight.inline.completion.InlineCompletionEvent
import com.intellij.codeInsight.inline.completion.InlineCompletionProvider
import com.intellij.codeInsight.inline.completion.InlineCompletionRequest
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

class OllamaCompletionProvider : InlineCompletionProvider {
    override suspend fun getProposals(request: InlineCompletionRequest): Flow<InlineCompletionElement> =
        channelFlow {
            send(InlineCompletionElement("Hello World"))
            awaitClose()
        }

    override fun isEnabled(event: InlineCompletionEvent): Boolean {
        return true
    }
}