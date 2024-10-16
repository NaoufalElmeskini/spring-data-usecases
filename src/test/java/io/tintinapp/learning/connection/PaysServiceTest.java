package io.tintinapp.learning.connection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.tintinapp.learning.MesBuilders;

@SpringBootTest
public class PaysServiceTest {
    
    @Autowired
    private PaysService paysService; 


    @Test
    @DisplayName("afficher les pays")
    public void afficherLesPays() {
        // given
        List<Pays> newPays = MesBuilders.plusieursPays(2);
        paysService.ajouter(newPays);

        // when
        List<String> pays = paysService.afficherLesPays();
        // then
        assertThat(pays).hasSize(2);
    }
}
