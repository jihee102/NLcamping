package com.jihee.nlcamping.customDraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.Model.Province;
import com.jihee.nlcamping.R;

public class GraphView extends View {
    private int numberOfFavorite =getCount();

    public GraphView(Context context) {
        super(context);
        init(null);
    }

    public GraphView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public GraphView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public GraphView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
    }

    private int getCount() {
        int output =0;
        for(Province p: CampingAdmin.provinces){
            if(p.getSelectedParks()!= null){
                output+= p.getSelectedParks().size();
            }
        }
        return output;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int[] colors = {
                ContextCompat.getColor(getContext(), R.color.graph1),
                ContextCompat.getColor(getContext(), R.color.graph2),
                ContextCompat.getColor(getContext(), R.color.graph3),
                ContextCompat.getColor(getContext(), R.color.graph4),
                ContextCompat.getColor(getContext(), R.color.graph5),
                ContextCompat.getColor(getContext(), R.color.graph6),
                ContextCompat.getColor(getContext(), R.color.graph7),
                ContextCompat.getColor(getContext(), R.color.graph8),
                ContextCompat.getColor(getContext(), R.color.graph9),
                ContextCompat.getColor(getContext(), R.color.graph10)};

        int width = canvas.getWidth();
        int squareSize = width / 10;
        int height = canvas.getHeight()-10;
        for (int i = 0; i < numberOfFavorite; i++) {
            Rect rect = new Rect();
            Paint paint = new Paint();
            rect.left = squareSize * i;
            rect.top = 0+5;
            rect.right = rect.left + squareSize;
            rect.bottom = rect.top + height;
            paint.setColor(colors[i]);
            canvas.drawRect(rect, paint);
        }
    }

}
