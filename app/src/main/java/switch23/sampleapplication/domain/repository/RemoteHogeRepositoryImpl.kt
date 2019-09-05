package switch23.sampleapplication.domain.repository

import switch23.sampleapplication.data.network.HogeApi
import switch23.sampleapplication.domain.model.HogeModel

class RemoteHogeRepositoryImpl(
    private val api: HogeApi
) : RemoteHogeRepository {
    override suspend fun getHoges(): List<HogeModel> = api.getHoges()
    override suspend fun postHoge(id: Int, body: String): HogeModel = api.postHoge(id, body)
}
