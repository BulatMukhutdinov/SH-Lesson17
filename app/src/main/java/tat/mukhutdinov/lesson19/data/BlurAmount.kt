package tat.mukhutdinov.lesson19.data

import androidx.annotation.StringRes

data class BlurAmount(
    @StringRes val blurAmountRes: Int,
    val blurAmount: Int
)
