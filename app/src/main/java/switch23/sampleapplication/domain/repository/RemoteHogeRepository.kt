package switch23.sampleapplication.domain.repository

import switch23.sampleapplication.domain.model.HogeModel

interface RemoteHogeRepository {
    suspend fun getHoges(): List<HogeModel>
    suspend fun postHoge(id: Int, body: String): HogeModel
}
