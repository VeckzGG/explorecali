package com.example.ec.service;

import com.example.ec.domain.Tour;
import com.example.ec.domain.TourPackage;
import com.example.ec.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    //code for String code of the package and name of the tour
    //finds the tour with same code name values, if it doesnt finds it,
    // then add a new one.
    public TourPackage createTourPackage(String code, String name){
        return tourPackageRepository.findById(code)
                .orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    public Iterable<TourPackage> lookup(){
        return tourPackageRepository.findAll();
    }

    public long total(){
        return tourPackageRepository.count();
    }

}
