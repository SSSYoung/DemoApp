package com.example.demoapp;

import android.content.Context;

public class DensityUtils {
   public static int dpToPx(Context context, float dp) {
      float density = context.getResources().getDisplayMetrics().density;
      return Math.round(dp * density);
   }
}
