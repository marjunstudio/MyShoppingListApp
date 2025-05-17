package to.msn.wings.mshoppinglistapp

data class LocationData(
    val latitude: Double,
    val longitude: Double
)

data class GeocodingResponse(
    val results: List<GeocodingResult>
)

data class GeocodingResult(
    val formatted_address: String
)