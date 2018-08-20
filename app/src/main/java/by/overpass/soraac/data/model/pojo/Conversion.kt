package by.overpass.soraac.data.model.pojo

import by.overpass.soraac.data.model.pojo.api.*
import by.overpass.soraac.data.model.pojo.db.*
import by.overpass.soraac.data.model.pojo.db.Mission
import by.overpass.soraac.data.model.pojo.db.Rocket

class Conversion {

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
                        description = it.missions?.takeIf { it.isNotEmpty() }?.get(0)?.description,
                        infoURL = it.infoURL.toString(),
                        vidURL = it.vidURL.toString(),
                        location = LocationConversion.fromApiToDB(it.location),
                        rocket = RocketConversion.fromApiToDB(it.rocket),
                        missions = MissionConversion.fromApiToDB(it.missions)
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
            return apiMissions?.map {
                Mission(
                        id = it.id,
                        name = it.name,
                        wikiURL = it.wikiURL,
                        infoURL = null,
                        description = it.description,
                        typeName = it.typeName,
                        agencies = AgencyConversion.fromApiToDB(it.agencies)
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