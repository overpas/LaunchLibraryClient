package by.overpass.soraac.data.model.pojo

import by.overpass.soraac.data.model.pojo.api.*
import by.overpass.soraac.data.model.pojo.db.*
import by.overpass.soraac.data.model.pojo.db.Mission
import by.overpass.soraac.data.model.pojo.db.Rocket

class Conversion {

    object LaunchConversion {
        fun fromApiToDB(jsonWrapper: LaunchJsonWrapper): List<by.overpass.soraac.data.model.pojo.db.Launch> {
            val apiLaunches = jsonWrapper.launches
            return apiLaunches.map { launch ->
                by.overpass.soraac.data.model.pojo.db.Launch(
                        id = launch.id,
                        name = launch.name,
                        startStamp = launch.wsstamp,
                        endStamp = launch.westamp,
                        netStamp = launch.netstamp,
                        locationName = launch.location?.name,
                        rocketImageURL = launch.rocket?.imageURL,
                        description = launch.missions?.takeIf { it.isNotEmpty() }?.get(0)?.description,
                        infoURL = launch.infoURL.toString(),
                        vidURL = launch.vidURL.toString(),
                        mapUrl = launch.location?.pads?.takeIf { it.isNotEmpty() }?.get(0)?.mapURL,
                        latitude = launch.location?.pads?.takeIf { it.isEmpty() }?.get(0)?.latitude,
                        longitude = launch.location?.pads?.takeIf { it.isEmpty() }?.get(0)?.longitude,
                        rocketId = launch.rocket?.id
                )
            }
        }
    }

    object PadConversion {
        fun fromApiToDB(apiPads: List<PadInLaunch>?): List<Pad>? {
            return apiPads?.map {
                Pad(
                        id = it.id,
                        name = it.name,
                        wikiURL = it.wikiURL,
                        infoURL = it.infoURL,
                        latitude = it.latitude,
                        longitude = it.longitude,
                        mapURL = it.mapURL
                )
            }
        }
    }


    object RocketConversion {
        fun fromApiToDB(jsonWrapper: RocketsJsonWrapper): List<Rocket> {
            val apiRockets = jsonWrapper.rockets
            return if (apiRockets == null) {
                listOf()
            } else {
                apiRockets.map { rocket ->
                    Rocket(
                            id = rocket?.id,
                            infoURL = rocket?.infoURL,
                            imageURL = rocket?.imageURL,
                            name = rocket?.name,
                            wikiURL = rocket?.wikiURL
                    )
                }
            }
        }

    }
}