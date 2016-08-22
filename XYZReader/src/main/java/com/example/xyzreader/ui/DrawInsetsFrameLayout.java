/*
 * Copyright 2014 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.xyzreader.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;

import com.example.xyzreader.R;


public class DrawInsetsFrameLayout extends FrameLayout {
    private Drawable insetBackground;
    private Rect insets;
    private Rect tempRect = new Rect();
    private OnInsetsCallback onInsetsCallback;

    public DrawInsetsFrameLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public DrawInsetsFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public DrawInsetsFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        final TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.DrawInsetsFrameLayout, defStyle, 0);
        assert a != null;

        insetBackground = a.getDrawable(R.styleable.DrawInsetsFrameLayout_insetBackground);

        a.recycle();
    }

    public void setInsetBackground(Drawable insetBackground) {
        if (this.insetBackground != null) {
            this.insetBackground.setCallback(null);
        }

        if (insetBackground != null) {
            insetBackground.setCallback(this);
        }

        this.insetBackground = insetBackground;
        postInvalidateOnAnimation();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requestApplyInsets();
        }
        if (insetBackground != null) {
            insetBackground.setCallback(this);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (insetBackground != null) {
            insetBackground.setCallback(null);
        }
    }

    public void setOnInsetsCallback(OnInsetsCallback onInsetsCallback) {
        this.onInsetsCallback = onInsetsCallback;
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        insets = super.onApplyWindowInsets(insets);
        this.insets = new Rect(
                insets.getSystemWindowInsetLeft(),
                insets.getSystemWindowInsetTop(),
                insets.getSystemWindowInsetRight(),
                insets.getSystemWindowInsetBottom());
        setWillNotDraw(false);
        postInvalidateOnAnimation();
        if (onInsetsCallback != null) {
            onInsetsCallback.onInsetsChanged(this.insets);
        }
        return insets;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();

        if (insets != null) {
            // Top
            tempRect.set(0, 0, width, insets.top);
            if (insetBackground != null) {
                insetBackground.setBounds(tempRect);
                insetBackground.draw(canvas);
            }

            // Bottom
            tempRect.set(0, height - insets.bottom, width, height);
            if (insetBackground != null) {
                insetBackground.setBounds(tempRect);
                insetBackground.draw(canvas);
            }

            // Left
            tempRect.set(0, insets.top, insets.left, height - insets.bottom);
            if (insetBackground != null) {
                insetBackground.setBounds(tempRect);
                insetBackground.draw(canvas);
            }

            // Right
            tempRect.set(width - insets.right, insets.top, width, height - insets.bottom);
            if (insetBackground != null) {
                insetBackground.setBounds(tempRect);
                insetBackground.draw(canvas);
            }
        }
    }

    public static interface OnInsetsCallback {
        public void onInsetsChanged(Rect insets);
    }
}
