package com.example.demoapp.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.demoapp.DensityUtils
import com.example.demoapp.R
import mvvm.SysApplication
import kotlin.math.roundToInt

class HistogramView @JvmOverloads constructor(context: Context, attrs: AttributeSet?) :
    View(context, attrs) {
//    private val bgPaint = Paint()
//    private var dataPaint = Paint()
//    private var leftLinePaint = Paint()     //左边渐变线条的
//    private var linePaint = Paint() //中间渐变线条的paint
//    private var rightLinePaint = Paint()    //右边渐变线条的paint
//    private var shaderPaint = Paint()
//    private var dataGradient: LinearGradient? = null
//    private var data: List<Float>? = null
//    private var viewWidth = 0f
//    private var viewHeight = 0f
//    private var gradientStartColor = 0
//    private var gradientEndColor = 0
//    private var bottomWidth = 0
//    private var red = 0//0~255
//    private var green = 0
//    private var blue = 0
//    private var alpha = 0 //0~255
//    private val shaderPath = Path() //阴影部分的path
//    private val linePath = Path()//折线线条的path
//    private val shaderCacheMap = HashMap<ShaderColor, LinearGradient?>() //Key:颜色值
//    private var type = TYPE_HISTOGRAM
//
//    companion object {
//        const val TAG = "Histogram"
//        const val SAMPLE_SIZE = 3 //采样次数
//        const val SHADER_SIZE = 3 //采样次数
//        const val INGREDIENT_COUNT = 6//渐变柱子的个数
//        const val INGREDIENT_DATA_SIZE = INGREDIENT_COUNT * SAMPLE_SIZE * 2
//        const val TYPE_HISTOGRAM = 0
//        const val TYPE_LINEGRAPH = 1
//        const val HISTOGRAM_ALPHA = 0.4f //直方图的alpha
//        const val LINE_GRAPH_COVER_ALPHA = 0.15f //折线图面积阴影覆盖率区域透明度
//        const val LINE_GRAPH_STROKE_ALPHA = 0.55f //折线图折线部分透明度
//        val STATS_SIZE =
//            DensityUtils.dpToPx(SysApplication.context, 132f) / (SAMPLE_SIZE * 2).also {
//                Log.d(TAG, "STATS_SIZE: ")
//            }
//        val DATA_SIZE = STATS_SIZE * SAMPLE_SIZE * 2
//    }
//
//    fun initPaint(context: Context) {
//        bgPaint.flags = Paint.ANTI_ALIAS_FLAG
//        bgPaint.color = Color.BLACK
//        bgPaint.alpha = 0
//        dataPaint.color = context.getColor(R.color.histogram_unit_end_color)
//        //dataPaint.color = Color.RED
//        linePaint.flags = Paint.ANTI_ALIAS_FLAG
//        linePaint.style = Paint.Style.STROKE
//        linePaint.color = context.getColor(R.color.net_delay_stroke_color)
//        linePaint.strokeWidth = DensityUtils.dpToPx(context, 0.33f).toFloat()
//
//        leftLinePaint.flags = Paint.ANTI_ALIAS_FLAG
//        leftLinePaint.style = Paint.Style.STROKE
//        leftLinePaint.strokeWidth = DensityUtils.dpToPx(context, 0.33f).toFloat()
//
//        rightLinePaint.flags = Paint.ANTI_ALIAS_FLAG
//        rightLinePaint.style = Paint.Style.STROKE
//        rightLinePaint.strokeWidth = DensityUtils.dpToPx(context, 0.33f).toFloat()
//
//        shaderPaint.flags = Paint.ANTI_ALIAS_FLAG
//    }
//
//    private fun initData(context: Context) {
//        gradientStartColor = context.getColor(R.color.histogram_unit_start_color)
//        gradientEndColor = context.getColor(R.color.histogram_unit_end_color)
//        bottomWidth =
//            context.resources.getDimensionPixelOffset(R.dimen.histogram_bottom_gradient_width)
//        alpha = gradientEndColor ushr 24
//        red = gradientEndColor and 0x00ff0000 shr 16
//        green = gradientEndColor and 0x0000ff00 shr 8
//        red = gradientEndColor and 0x000000ff
//    }
//
//    fun setData(list: List<Float>) {
//        data = list
//        invalidateExt()
//    }
//
//    fun setType(dataType: Int) {
//        type = dataType
//        invalidateExt()
//    }
//
//    fun setColor(color: Int) {
//        gradientEndColor = color
//        alpha = gradientEndColor ushr 24
//        red = gradientEndColor and 0x00ff0000 shr 16
//        green = gradientEndColor and 0x0000ff00 shr 8
//        red = gradientEndColor and 0x000000ff
//    }
//
//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        viewWidth = w.toFloat()
//        viewHeight = h.toFloat()
//        super.onSizeChanged(w, h, oldw, oldh)
//    }
//
//    override fun onDraw(canvas: Canvas?) {
//        if (type == TYPE_HISTOGRAM) {
//            drawHistogram(canvas)
//        } else if (type == TYPE_LINEGRAPH) {
//            drawLineGraph(canvas)
//        }
//    }
//
//    /**
//     * 画直方图
//     */
//    private fun drawHistogram(canvas: Canvas?) {
//        var left: Float
//        var right: Float
//        var bottom: Float
//        var height: Float
//        val barWidth = (viewWidth / DATA_SIZE).roundToInt() //像素点取整，保证宽度都一致
//        val startColor = Color.argb(0, red, green, blue)
//        var endColor: Int
//        var shaderColor: ShaderColor
//
//        data?.forEachIndexed { index, value ->
//            if (value.compareTo(0f) > 0) {
//                left = (barWidth * index).toFloat()
//                bottom = viewHeight
//                right = left + barWidth
//                height = viewHeight - value * viewHeight
//
//                var ratio = 1f
//                if (index < INGREDIENT_DATA_SIZE) {
//                    // 左边的渐变
//                    ratio = index.toFloat() / INGREDIENT_DATA_SIZE
//                } else if (index >= DATA_SIZE - INGREDIENT_DATA_SIZE){
//                    // 右边的渐变
//                    ratio = (DATA_SIZE - index).toFloat() / INGREDIENT_DATA_SIZE
//                }
//
//                endColor = Color.argb((255 * HISTOGRAM_ALPHA * ratio).toInt(),red, green, blue)
//                shaderColor = ShaderColor(startColor.endColor)
//            }
//        }
//    }
//
//    private fun drawLineGraph(canvas: Canvas?) {
//
//    }
}