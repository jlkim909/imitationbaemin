package com.hodak.imitationbaemin.core.model.data

data class StoreResource(
    val name: String,
    val rating: Float,
    val deliveryMinTime: Int,
    val deliveryMaxTime: Int,
    val deliveryMinTip: Int,
    val deliveryMaxTip: Int,
    val enabledCoupon: Boolean = false,
    val couponText: String,
    val tags: List<StoreTagData>,
    val thumbnailRes: Int,
)

data class StoreTagData(
    val type: StoreTagType,
    val text: String = "",
)