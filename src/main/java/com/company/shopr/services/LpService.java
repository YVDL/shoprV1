package com.company.shopr.services;

import com.company.shopr.domain.Lp;
import com.company.shopr.repositories.LpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LpService {

    @Autowired
    LpRepository lpRepository;

    public List<Lp> getLps() {
        return lpRepository.getLps();
    }

    public void addLp(Lp newLp) {
        lpRepository.addLp(newLp);
    }

    public void updateLp(Lp newLp) { lpRepository.updateLp(newLp); }

    public Lp findLpById(Long id) {
        return lpRepository.findLpById(id);
    }

    public void editLpById(Lp editedLp) { lpRepository.editLpById(editedLp); }

    public void removeLp(long id) { lpRepository.removeLp(id); }
    }


