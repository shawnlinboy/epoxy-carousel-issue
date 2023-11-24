package com.test.TestEpoxy

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp

// The ModelView annotation is used on Views to have models generated from those views.
// This is pretty straightforward with Kotlin, but properties need some special handling.
@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT)
class ItemCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val textView: TextView

    // 2. Or you can use lateinit
    @TextProp
    lateinit var title: CharSequence

    init {
        inflate(context, R.layout.item_list, this)
        orientation = VERTICAL
        textView = (findViewById(android.R.id.text1))
    }

    @AfterPropsSet
    fun useProps() {
        // This is optional, and is called after the annotated properties above are set.
        // This is useful for using several properties in one method to guarantee they are all set first.
        textView.text = "Horizontal Item $title"
    }

    companion object {
        private const val TAG = "ItemCustomView"
    }
}
