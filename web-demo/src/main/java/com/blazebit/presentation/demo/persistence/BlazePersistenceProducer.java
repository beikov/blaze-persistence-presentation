/*
 * Copyright 2014 Blazebit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blazebit.presentation.demo.persistence;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.spi.EntityViewConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;

/**
 * @author Moritz Becker (moritz.becker@gmx.at)
 * @since 1.2
 */
@ApplicationScoped
public class BlazePersistenceProducer {

    @Produces
    @ApplicationScoped
    public CriteriaBuilderFactory createCriteriaBuilderFactory(final EntityManagerFactory emf) {
        return Criteria.getDefault().createCriteriaBuilderFactory(emf);
    }

    @Produces
    @ApplicationScoped
    public EntityViewManager createEntityViewManager(
            final EntityManagerFactory emf,
            final CriteriaBuilderFactory cbf,
            final EntityViewConfiguration entityViewConfiguration) {
        return entityViewConfiguration.createEntityViewManager(cbf, emf);
    }
}