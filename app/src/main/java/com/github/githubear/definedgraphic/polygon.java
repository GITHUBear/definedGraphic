package com.github.githubear.definedgraphic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by dell on 2016/10/29.
 */

public class polygon extends ImageView{


    public polygon(Context context){
        super(context);
    }
    public polygon(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }
    public polygon(Context context,AttributeSet attributeSet,int defstyle){
        super(context,attributeSet,defstyle);
    }
    public void onDraw(Canvas canvas){
        Drawable drawable=getDrawable();
        if(drawable==null){
            return;
        }
        if(getHeight()==0||getWidth()==0){
            return;
        }
        Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();
        if(bitmap==null){
            return;
        }
        Bitmap bitmap1=bitmap.copy(Bitmap.Config.ARGB_8888,true);
        int height=getHeight();
        int width=getWidth();
        if(height>width){
            Bitmap polygonBitmap=getBitmap(bitmap1,width);
            canvas.drawBitmap(polygonBitmap,0,0,null);
            return;
        }else {
            Bitmap polygonBitmap = getBitmap(bitmap1, height);
            canvas.drawBitmap(polygonBitmap, 0, 0, null);
            return;
        }
    }

    public static Bitmap getBitmap(Bitmap bitmap,int length) {
        Bitmap p;
        if (bitmap.getWidth() != length || bitmap.getHeight() != length) {
            p = Bitmap.createScaledBitmap(bitmap, length, length, false);
        } else {
            p = bitmap;
        }
        Bitmap output = Bitmap.createBitmap(p.getWidth(), p.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(output);
        final Paint paint=new Paint();
        final Rect rect=new Rect(0,0,p.getWidth(),p.getHeight());
        paint.setDither(true);
        canvas.drawARGB(0,0,0,0);
        paint.setColor(Color.parseColor("#BAB399"));
        float p_x=p.getWidth()/2+0.7f;
        float p_y=p.getHeight()/2+0.7f;
        float r=p.getWidth()/2+0.1f;
        double gap=2*Math.PI/6;
        paint.setStyle(Paint.Style.FILL);
        Path path=new Path();
        path.moveTo(p_x+r,p_y);
        for(int i=1;i<6;i++){
            path.lineTo((float)(p_x+r*Math.cos(i*gap)),(float)(p_y+r*Math.sin(i*gap)));
        }
        path.close();
        canvas.drawPath(path,paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(p,rect,rect,paint);
        return output;
    }
}
