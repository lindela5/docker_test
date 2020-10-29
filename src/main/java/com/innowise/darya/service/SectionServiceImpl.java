package com.innowise.darya.service;

import com.innowise.darya.entity.Section;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SectionServiceImpl implements SectionService{
    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public Section getSectionStats(Long sectionId) {
        Section section = sectionRepository.findById(sectionId);
        if (section == null) {
            throw new ThereIsNoSuchException("section");
        }

        return section;
    }
}
