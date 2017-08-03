package io.github.vzer.sharevegetable.vegetable.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import io.github.vzer.sharevegetable.R;

/**
 * 添加商品动画
 * @author: Vzer.
 * @date: 2017/8/3. 13:09
 * @email: vzer@qq.com
 */
public class ShoppingCartAnimationView extends TextView implements ValueAnimator.AnimatorUpdateListener {

    public static final int VIEW_SIZE = 20;

    protected Context mContext;
    protected Paint mPaint4Circle;
    protected int radius;

    protected Point startPosition;
    protected Point endPosition;


    public ShoppingCartAnimationView(Context context) {
        this(context, null);
    }

    public ShoppingCartAnimationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShoppingCartAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        mPaint4Circle = new Paint();
        mPaint4Circle.setColor(getResources().getColor(R.color.colorPrimary));
        mPaint4Circle.setAntiAlias(true);


        setGravity(Gravity.CENTER);
        setText("1");
        setTextColor(Color.WHITE);
        setTextSize(12);
    }


    public void setStartPosition(Point startPosition) {
        startPosition.y -= 10;
        this.startPosition = startPosition;
    }

    public void setEndPosition(Point endPosition) {
        this.endPosition = endPosition;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int SIZE = (int) convertDpToPixel(VIEW_SIZE, mContext);
        setMeasuredDimension(SIZE, SIZE);
        radius = SIZE / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, radius, mPaint4Circle);
        super.onDraw(canvas);
    }

    /**
     * 开始贝塞尔曲线动画(二阶)
     */
    public void startBeizerAnimation() {
        if (startPosition == null || endPosition == null) return;
        int pointX = (startPosition.x + endPosition.x) / 2;
        int pointY = (int) (startPosition.y - convertDpToPixel(100, mContext));
        Point controllPoint = new Point(pointX, pointY);
        BezierEvaluator bezierEvaluator = new BezierEvaluator(controllPoint);
        ValueAnimator anim = ValueAnimator.ofObject(bezierEvaluator, startPosition, endPosition);
        anim.addUpdateListener(this);
        anim.setDuration(400);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ViewGroup viewGroup = (ViewGroup) getParent();
                viewGroup.removeView(ShoppingCartAnimationView.this);
            }
        });
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        Point point = (Point) animation.getAnimatedValue();
        setX(point.x);
        setY(point.y);
        invalidate();
    }


    public class BezierEvaluator implements TypeEvaluator<Point> {

        private Point controllPoint;

        public BezierEvaluator(Point controllPoint) {
            this.controllPoint = controllPoint;
        }

        @Override
        public Point evaluate(float t, Point startValue, Point endValue) {
            int x = (int) ((1 - t) * (1 - t) * startValue.x + 2 * t * (1 - t) * controllPoint.x + t * t * endValue.x);
            int y = (int) ((1 - t) * (1 - t) * startValue.y + 2 * t * (1 - t) * controllPoint.y + t * t * endValue.y);
            return new Point(x, y);
        }

    }

    /**
     * dp换成当前分辨率px
     */
    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();

        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }
}
