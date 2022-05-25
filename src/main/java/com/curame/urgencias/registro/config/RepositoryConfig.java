package com.curame.urgencias.registro.config;

import com.curame.urgencias.registro.models.entity.EmergencyRecord;
import com.curame.urgencias.registro.models.entity.Pacient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Pacient.class, EmergencyRecord.class);
    }
}
