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

    object LocationConversion {

        fun fromApiToDB(apiLocation: LocationInLaunch?): Location {
            return Location(
                    id = apiLocation?.id,
                    infoURL = apiLocation?.infoURL,
                    wikiURL = apiLocation?.wikiURL,
                    name = apiLocation?.name,
                    countryCode = apiLocation?.countryCode,
                    pads = PadConversion.fromApiToDB(apiLocation?.pads)
            )
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

        fun fromApiToDB(apiRocket: RocketInLaunch?): Rocket? {
            return Rocket(
                    id = apiRocket?.id,
                    wikiURL = apiRocket?.wikiURL,
                    name = apiRocket?.name,
                    imageURL = apiRocket?.imageURL,
                    infoURL = apiRocket?.infoURLs
            )
        }

    }

    object MissionConversion {

        fun fromApiToDB(apiMissions: List<MissionInLaunch>?): List<Mission>? {
            return apiMissions?.map { missionInLaunch ->
                Mission(
                        id = missionInLaunch.id,
                        name = missionInLaunch.name,
                        wikiURL = missionInLaunch.wikiURL,
                        infoURL = null,
                        description = missionInLaunch.description,
                        typeName = missionInLaunch.typeName,
                        agencyName = missionInLaunch.agencies?.takeIf { it.isNotEmpty() }?.get(0)?.name,
                        agencyWikiUrl = missionInLaunch.agencies?.takeIf { it.isNotEmpty() }?.get(0)?.wikiURL
                )
            }
        }

    }

    object AgencyConversion {

        fun fromApiToDB(apiAgencies: List<AgencyInLaunch>?): List<Agency>? {
            return apiAgencies?.map {
                Agency(
                        id = it.id,
                        name = it.name,
                        wikiURL = it.wikiURL,
                        infoURL = it.infoURL.toString(),
                        countryCode = it.countryCode,
                        abbrev = it.abbrev
                )
            }
        }

    }

}