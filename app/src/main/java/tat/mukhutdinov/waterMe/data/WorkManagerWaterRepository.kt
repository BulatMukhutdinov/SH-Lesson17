package tat.mukhutdinov.waterMe.data

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import tat.mukhutdinov.waterMe.model.Plant
import tat.mukhutdinov.waterMe.worker.WaterReminderWorker
import java.util.concurrent.TimeUnit

class WorkManagerWaterRepository(context: Context) : WaterRepository {
    private val workManager = WorkManager.getInstance(context)

    override val plants: List<Plant>
        get() = DataSource.plants

    override fun scheduleReminder(duration: Long, unit: TimeUnit, plantName: String) {
        val data = workDataOf(WaterReminderWorker.nameKey to plantName)

        val waterReminder = OneTimeWorkRequestBuilder<WaterReminderWorker>()
            .setInputData(data)
            .setInitialDelay(duration, unit)
            .build()

        val uniqueName = plantName + duration.toString()

        workManager.enqueueUniqueWork(
            uniqueName,
            ExistingWorkPolicy.REPLACE,
            waterReminder
        )
    }
}
