package com.example.cityrooter.datamodel

data class HomeResponseModel(
    val headerImageList: List<String>,
    val bannerImage: String,
    val mainInfoList: List<TitleLabelImageModel>,
    val sellingPointsBanner: String,
    val sellingPoints: List<TitleLabelImageModel>,
    val adVideo: String,
    val aboutUsBanner: String,
    val aboutUs: String,
    val custSummariesBanner: String,
    val custSummaries: List<CustSummaryModel>,
    val superioritiesBanner: String,
    val superiorities: List<String>,
    val servicesBanner: String,
    val services: List<String>,
    val galleriesBanner: String,
    val galleries: List<String>,
    val address: String,
    val phone: String,
    val email: String
)
