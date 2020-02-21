package org.kavus.jobzapp.repo;

import org.kavus.jobzapp.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
}
