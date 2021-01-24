package com.example.cityrooter.datamodel

data class HomeResponseModel(
    val headerImageList: List<String>,
    val bannerImage: String,
    val mainInfoList: List<TitleLabelImageModel>,
    val sellingPoints: List<TitleLabelImageModel>,
    val adVideo: String,
    val aboutUs: String,
    val custSummaries: List<CustSummaryModel>,
    val superiorities: List<String>,
    val services: List<String>,
    val galleries: List<String>
)
