package com.tynkovski.android.myapplication2

import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet
import android.view.WindowInsets
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline

class InsetAwareConstraintLayout : ConstraintLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets? {
        if (Build.VERSION.SDK_INT < 30) {
            return super.onApplyWindowInsets(insets)
        }

        val windowInsets =
            insets.getInsets(
                WindowInsets.Type.systemBars() or
                    WindowInsets.Type.ime() or
                    WindowInsets.Type.displayCutout()
            )

        applyInsets(
            Rect(
                windowInsets.left,
                windowInsets.top,
                windowInsets.right,
                windowInsets.bottom
            )
        )

        return super.onApplyWindowInsets(insets)
    }

    override fun fitSystemWindows(insets: Rect): Boolean {
        if (Build.VERSION.SDK_INT >= 30) {
            return true
        }
        applyInsets(insets)
        return true
    }

    private fun applyInsets(insets: Rect) {
        val statusBarGuideline by lazy { findViewById<Guideline>(R.id.status_bar_guideline) }
        val navigationBarGuideline by lazy { findViewById<Guideline>(R.id.navigation_bar_guideline) }
        val parentStartGuideline by lazy { findViewById<Guideline>(R.id.parent_start_guideline) }
        val parentEndGuideline by lazy { findViewById<Guideline>(R.id.parent_end_guideline) }

        statusBarGuideline?.setGuidelineBegin(insets.top)
        navigationBarGuideline?.setGuidelineEnd(insets.bottom)
        parentStartGuideline?.setGuidelineBegin(insets.left)
        parentEndGuideline?.setGuidelineEnd(insets.right)
    }
}