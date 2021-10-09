package com.example.pharmasictapp.ui.home_layout.fragments.courses

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CourseItemSeparatedSpace(private val space: Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = space
        }
        outRect.right = space
        outRect.left=space
        outRect.bottom=space
    }

}
