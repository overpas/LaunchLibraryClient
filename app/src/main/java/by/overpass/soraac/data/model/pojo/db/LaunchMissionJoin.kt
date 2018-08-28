package by.overpass.soraac.data.model.pojo.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

@Entity(
        tableName = "launch_mission",
        primaryKeys = ["launchId", "missionId"],
        foreignKeys = [
            ForeignKey(entity = Launch::class, parentColumns = ["id"], childColumns = ["launchId"]),
            ForeignKey(entity = Mission::class, parentColumns = ["id"], childColumns = ["missionId"])
        ]
)
data class LaunchMissionJoin(
        var launchId: Int?,
        var missionId: Int?
)