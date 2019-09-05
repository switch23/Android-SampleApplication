package switch23.sampleapplication.domain.usecase

import switch23.sampleapplication.domain.model.HogeModel
import switch23.sampleapplication.domain.repository.RemoteHogeRepository

class SampleListUseCase(private val hogeRepository: RemoteHogeRepository) {
    suspend fun getHoges(): List<HogeModel> = hogeRepository.getHoges()
}
