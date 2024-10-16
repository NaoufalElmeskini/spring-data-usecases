package io.tintinapp.learning.connection;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceIntergalactique {

    public void appelerLespace(){
        try {
            log.info("appel vers l'espace...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info("appel : fin");
        }
    }
}
