package org.kavus.jobzapp.repo;

import org.kavus.jobzapp.entity.Definition;
import org.kavus.jobzapp.entity.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization<Definition>,Long> {
}
