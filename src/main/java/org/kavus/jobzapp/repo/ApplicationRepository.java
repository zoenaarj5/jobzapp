package org.kavus.jobzapp.repo;

import org.kavus.jobzapp.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application,Long> {
}
