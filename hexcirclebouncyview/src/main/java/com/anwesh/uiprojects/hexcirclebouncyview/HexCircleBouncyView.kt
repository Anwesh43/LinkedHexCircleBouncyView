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
val ballRFactor : Int = 5
val ballSFactor : Int = 3
val foreColor : Int = Color.parseColor("#4CAF50")
