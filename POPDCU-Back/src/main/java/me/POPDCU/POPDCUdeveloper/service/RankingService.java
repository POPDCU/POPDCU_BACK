package me.POPDCU.POPDCUdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.POPDCU.POPDCUdeveloper.domain.College;
import me.POPDCU.POPDCUdeveloper.repositroy.RankingRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RankingService {
    private final RankingRepository rankingRepository;

    public List<College> findAllSort(){
        return rankingRepository.findAll(Sort.by(Sort.Direction.DESC,"countNumber"));
    }

    public College findById(long id){
        return rankingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }
    public College findByName(String name){
        return rankingRepository.findByCollegeName(name);
    }
}
