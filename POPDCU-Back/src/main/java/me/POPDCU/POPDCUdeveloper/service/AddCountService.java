package me.POPDCU.POPDCUdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.POPDCU.POPDCUdeveloper.domain.College;
import me.POPDCU.POPDCUdeveloper.dto.AddCountRequest;
import me.POPDCU.POPDCUdeveloper.repositroy.AddCountRepository;
import me.POPDCU.POPDCUdeveloper.repositroy.RankingRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddCountService {
    private final AddCountRepository addCountRepository;

    @Transactional
    public College addCountId(final long id, final AddCountRequest addCountRequest){
        College college = addCountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found:" + id));
        college.AddCountNumber(addCountRequest.getCountNumber());
        return college;
    }
    @Transactional
    public College addCountName(final String collegeName, final AddCountRequest addCountRequest){
        College college = addCountRepository.findByCollegeName(collegeName);
        college.AddCountNumber(addCountRequest.getCountNumber());
        return college;
    }
}
