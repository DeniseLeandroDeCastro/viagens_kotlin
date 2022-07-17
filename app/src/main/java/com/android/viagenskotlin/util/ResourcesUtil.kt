package com.android.viagenskotlin.util

import android.content.Context
import android.graphics.drawable.Drawable

object ResourcesUtil {
    const val DRAWABLE = "drawable"
    fun devolveDrawable(
        context: Context,
        drawableEmTexto: String?
    ): Drawable {
        val resources = context.resources
        val idDoDrawable = resources.getIdentifier(
            drawableEmTexto, DRAWABLE, context.packageName
        )
        return resources.getDrawable(idDoDrawable)
    }
}