package by.overpass.soraac.data.model.pojo.db

data class Location(
        var pads: List<Pad>?,
        var id: Int?,
        var name: String?,
        var infoURL: String?,
        var wikiURL: String?,
        var countryCode: String?
)