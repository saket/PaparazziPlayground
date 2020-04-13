package me.saket.paparazziplayground.pprzzi

import android.content.Context
import android.graphics.Color
import android.text.SpannableStringBuilder
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.util.TypedValue.COMPLEX_UNIT_SP
import android.widget.TextView
import androidx.core.text.color
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
        .append("**bold**")
        .append(", ")
        .append("*italic*")
        .append(", ")
        .append("~~strikethrough~~")
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
}
