package by.overpass.soraac.data.model.pojo

import by.overpass.soraac.data.model.pojo.api.LaunchJsonWrapper

object LaunchConversion {

    fun fromApiToDB(jsonWrapper: LaunchJsonWrapper): List<by.overpass.soraac.data.model.pojo.db.Launch> {
        val apiLaunches = jsonWrapper.launches
        return apiLaunches.map {
            by.overpass.soraac.data.model.pojo.db.Launch(
                    id = it.id,
                    name = it.name,
                    startStamp = it.wsstamp,
                    endStamp = it.westamp,
                    netStamp = it.netstamp,
                    locationName = it.location?.name,
                    rocketImageURL = it.rocket?.imageURL,
                    description = it.missions?.takeIf { it.size > 0 }?.get(0)?.description
            )
        }
    }

}