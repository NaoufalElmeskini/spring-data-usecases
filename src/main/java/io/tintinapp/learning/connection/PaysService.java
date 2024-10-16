package io.tintinapp.learning.connection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.tintinapp.learning.connection.PaysRepo;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class PaysService   implements PaysIf {
    @Autowired
    private PaysRepo paysRepo;

    @Autowired
    private ServiceIntergalactique serviceIntergalactique;

    

    @Override
    @Transactional
    public List<String> afficherLesPays() {
        List<String> list = paysRepo.findAll().stream()
                .map(Pays::getNom)
                .toList();
        serviceIntergalactique.appelerLespace();
        log.info(list.toString());

        return list;
    }

    public void ajouter(Pays pays) {
        paysRepo.save(pays);
    }
    public void ajouter(List<Pays> pays) {
        paysRepo.saveAll(pays);
    }

}
