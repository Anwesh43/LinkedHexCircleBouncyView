package com.anwesh.uiprojects.hexcirclebouncyview

/**
 * Created by anweshmishra on 07/07/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color

val nodes : Int = 5
val balls : Int = 6
val parts : Int = 2
val scGap : Float = 0.02f / parts
val sizeFactor : Float = 2.9f
val ballRFactor : Float = 3.5f
val ballSFactor : Int = 3
val foreColor : Int = Color.parseColor("#4CAF50")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawHexBouncyCircle(scale : Float, size : Float, paint : Paint) {
    val r : Float = size / ballRFactor
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    val deg : Float = 360f / balls
    val initR : Float = r / ballSFactor
    val uR : Float = r - initR
    save()
    scale(sf1, sf1)
    for (j in 0..(balls - 1)) {
        val sf2j : Float = sf2.divideScale(j, balls)
        save()
        rotate(deg * j)
        drawCircle(0f, size, initR + (uR) * sf2j.sinify(), paint)
        restore()
    }
    restore()
}

fun Canvas.drawHCBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    save()
    translate(w / 2, gap * (i + 1))
    drawHexBouncyCircle(scale, size, paint)
    restore()
}
