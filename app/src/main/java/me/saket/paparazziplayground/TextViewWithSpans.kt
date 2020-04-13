package me.saket.paparazziplayground

import android.content.Context
import android.graphics.Color
import android.text.SpannableStringBuilder
import android.util.AttributeSet
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.color
import androidx.core.text.italic
import androidx.core.text.strikeThrough

class TextViewWithSpans(context: Context, attrs: AttributeSet) : TextView(context, attrs) {
  init {
    text = SpannableStringBuilder("Press understands standard markdown syntaxes, including: ")
        .bold { append("**bold**") }
        .append(", ")
        .italic { append("*italic*") }
        .append(", ")
        .strikeThrough { append("~~strikethrough~~") }
        .append(", and many more.")
  }
}
