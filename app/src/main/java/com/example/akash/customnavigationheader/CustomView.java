package com.example.akash.customnavigationheader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by akash on 08-02-2017.
 */

public class CustomView extends View {

    Context context;
    Paint paint = new Paint();
    Paint paint1 = new Paint();
    Paint paint2 = new Paint();
    Paint paint3 = new Paint();
    RectF squareRect, squareRect1, squareRect2, squareRect3;
    float rotation = 0f;
    private int measuredDimenson;
//    private float innerRadius, outerRadius, centerX, centerY;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CustomView(Context context) {
        super(context);
        this.context = context;
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }
//    get value of rotate from DrawerListeners onDrawerSlide() method
    public void rotateRect(float rotate) {
        rotation = rotate;
        postInvalidate();
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

            paint2.setColor(ContextCompat.getColor(context, R.color.colorAccent) - 425);
            paint2.setAntiAlias(true);
            paint2.setShadowLayer(40, 0, 0, Color.DKGRAY);
            setLayerType(LAYER_TYPE_SOFTWARE, paint2);
            canvas.save(canvas.MATRIX_SAVE_FLAG);
            canvas.rotate(rotation * 55, getWidth() / 2, getWidth() / 2);
            canvas.drawRect(squareRect2, paint2);
            canvas.restore();

            paint.setAntiAlias(true);
            paint.setColor(ContextCompat.getColor(context, R.color.colorAccent) - 275);
            paint.setShadowLayer(38, 0, 0, Color.DKGRAY);
            setLayerType(LAYER_TYPE_SOFTWARE, paint);
            canvas.save(canvas.MATRIX_SAVE_FLAG);
            canvas.rotate(rotation * 55, getWidth() / 2, getWidth() / 2);
            canvas.drawRect(squareRect, paint);
            canvas.restore();

            paint1.setColor(ContextCompat.getColor(context, R.color.colorAccent) + 285);
            paint1.setAntiAlias(true);
            paint1.setShadowLayer(36, 0, 0, Color.DKGRAY);
            setLayerType(LAYER_TYPE_SOFTWARE, paint1);
            canvas.save(canvas.MATRIX_SAVE_FLAG);
            canvas.rotate(rotation * 55, canvas.getWidth() / 2f, canvas.getWidth() / 2f);
            canvas.drawRect(squareRect1, paint1);
            canvas.restore();

            paint3.setColor(ContextCompat.getColor(context, R.color.colorAccent) + 250);
            paint3.setAntiAlias(true);
            paint3.setShadowLayer(34, 0, 0, Color.DKGRAY);
            setLayerType(LAYER_TYPE_SOFTWARE, paint2);
            canvas.save(canvas.MATRIX_SAVE_FLAG);
            canvas.rotate(rotation * 55, canvas.getWidth() / 2, canvas.getWidth() / 2);
            canvas.drawRect(squareRect3, paint3);
            canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        squareRect = new RectF();
        squareRect1 = new RectF();
        squareRect2 = new RectF();
        squareRect3 = new RectF();
        int measuredHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        int measuredWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);


        measuredDimenson = Math.min(measuredHeight, measuredWidth);

        squareRect2.set(0.25f * measuredDimenson, 0.25f * measuredDimenson + 25, 0.85f * measuredDimenson + 500, 0.85f * measuredDimenson + 400);
        squareRect.set(0.25f * measuredDimenson + 225, 0.25f * measuredDimenson - 150, 0.85f * measuredDimenson + 500, 0.85f * measuredDimenson + 300);
        squareRect1.set(0.25f * measuredDimenson + 175, 0.25f * measuredDimenson + 50, 0.85f * measuredDimenson + 500, 0.85f * measuredDimenson + 300);
        squareRect3.set(0.25f * measuredDimenson + 350, 0.25f * measuredDimenson, 0.85f * measuredDimenson + 500, 0.85f * measuredDimenson + 300);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }
}
