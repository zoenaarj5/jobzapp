package org.kavus.jobzapp.repo;

import org.kavus.jobzapp.entity.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Long> {
}
