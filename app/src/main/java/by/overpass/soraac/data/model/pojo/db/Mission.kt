package by.overpass.soraac.data.model.pojo.db

data class Mission(
        var id: Int?,
        var name: String?,
        var description: String?,
        var agencies: List<Agency?>?,
        var typeName: String?,
        var infoURL: String?,
        var wikiURL: String?
)