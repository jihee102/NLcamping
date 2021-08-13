package com.jihee.nlcamping.customDraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.core.content.ContextCompat;

import com.jihee.nlcamping.R;

public class PieChartView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float[] value_degree;
    private int[] COLORS={
            ContextCompat.getColor(getContext(), R.color.north_holland),
            ContextCompat.getColor(getContext(), R.color.drenthe),
            ContextCompat.getColor(getContext(), R.color.flevoland),
            ContextCompat.getColor(getContext(), R.color.frisland),
            ContextCompat.getColor(getContext(), R.color.gelderland),
            ContextCompat.getColor(getContext(), R.color.groningen),
            ContextCompat.getColor(getContext(), R.color.limburg),
            ContextCompat.getColor(getContext(), R.color.north_brabant),
            ContextCompat.getColor(getContext(), R.color.soouth_holland),
            ContextCompat.getColor(getContext(), R.color.overijssel),
            ContextCompat.getColor(getContext(), R.color.utrecht),
            ContextCompat.getColor(getContext(), R.color.zeeland)};
    int temp=0;

    public PieChartView(Context context, float[] values) {
        super(context);
        value_degree=new float[values.length];
        for(int i=0;i<values.length;i++)
        {
            value_degree[i]=values[i];
        }

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectf = new RectF (50, 50, 700, 700);

        for (int i = 0; i < value_degree.length; i++) {
            if (i == 0) {
                paint.setColor(COLORS[i]);
                canvas.drawArc(rectf, 0, value_degree[i], true, paint);
            }
            else
            {
                temp += (int) value_degree[i - 1];
                paint.setColor(COLORS[i]);
                canvas.drawArc(rectf, temp, value_degree[i], true, paint);
            }
        }
    }

}
