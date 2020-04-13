package me.saket.paparazziplayground.pprzzi

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.SpannableStringBuilder
import android.text.StaticLayout
import android.text.TextPaint
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.util.TypedValue.COMPLEX_UNIT_SP
import android.view.View
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.italic
import androidx.core.text.strikeThrough
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_3
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test
import kotlin.math.roundToInt

class PaparazziTest {

  @get:Rule
  var paparazzi = Paparazzi(deviceConfig = PIXEL_3)

  private val context: Context
    get() = paparazzi.context

  @Test fun spans() {
    val markdown = SpannableStringBuilder("Press understands standard markdown syntaxes, including: ")
        .bold { append("**bold**") }
        .append(", ")
        .italic { append("*italic*") }
        .append(", ")
        .strikeThrough { append("~~strikethrough~~") }
        .append(", and many more.")

    val textView = TextView(context).apply {
      text = markdown
      setBackgroundColor(0xFF353846.toInt())
      setTextColor(Color.WHITE)
      setPaddingRelative(16.dp, 16.dp, 16.dp, 0)
    }
    paparazzi.snapshot(textView)
  }

  private val Int.dp: Int
    get() {
      val metrics = context.resources.displayMetrics
      return TypedValue.applyDimension(COMPLEX_UNIT_DIP, this.toFloat(), metrics).roundToInt()
    }

  private val Float.sp: Float
    get() {
      val metrics = context.resources.displayMetrics
      return TypedValue.applyDimension(COMPLEX_UNIT_SP, this, metrics)
    }
}
