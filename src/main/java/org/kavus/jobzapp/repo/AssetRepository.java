package org.kavus.jobzapp.repo;

import org.kavus.jobzapp.entity.Asset;
import org.kavus.jobzapp.entity.Experience;
import org.springframework.data.repository.CrudRepository;

public interface AssetRepository extends CrudRepository<Asset,Long> {
}
