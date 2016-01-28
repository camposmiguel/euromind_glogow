package com.miguelcr.navigationdrawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by miguelcampos on 26/1/16.
 */
public class StationIconView extends View {
        // setup initial color
        private final int circleColor = R.color.colorPrimary;
        private final int lineColorGreen = R.color.colorPrimary;
        private final int lineColorRed = R.color.colorPrimary;
        // defines paint and canvas
        private Paint drawPaint;

        public StationIconView(Context context, AttributeSet attrs) {
            super(context, attrs);
            setFocusable(true);
            setFocusableInTouchMode(true);
            setupPaint();
        }

        // Setup paint with color and stroke styles
        private void setupPaint() {
            // Circle
            drawPaint = new Paint();
            drawPaint.setColor(ContextCompat.getColor(getContext(), circleColor));
            drawPaint.setAntiAlias(true);
            drawPaint.setStrokeWidth(5);
            drawPaint.setStyle(Paint.Style.FILL);
            drawPaint.setStrokeJoin(Paint.Join.ROUND);
            drawPaint.setStrokeCap(Paint.Cap.ROUND);


        }

        @Override
        protected void onDraw(Canvas canvas) {

            // Linea Superior
            drawPaint.setStrokeWidth(60);
            drawPaint.setColor(ContextCompat.getColor (getContext(),lineColorGreen));
            canvas.drawLine(125, 0, 125, 150, drawPaint);

            // Linea Inferior
            drawPaint.setColor(ContextCompat.getColor (getContext(),lineColorRed));
            canvas.drawLine(125,150,125,300,drawPaint);

            // Circulo
            drawPaint.setStrokeWidth(5);
            drawPaint.setColor(ContextCompat.getColor (getContext(),circleColor));
            canvas.drawCircle(125, 150, 80, drawPaint);
        }
}
