package com.innowise.darya.service;

import com.innowise.darya.entity.Section;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SectionService {
    private SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }


    public Section getSectionStats(Long sectionId) {
        Section section = sectionRepository.findById(sectionId);
        if (section == null) {
            throw new ThereIsNoSuchException();
        }

        return section;
    }
}
