package org.kavus.jobzapp.entity;

import javax.persistence.*;
import java.util.Set;
import java.util.Set;

@Entity
public class Job extends Definable<LDefinition> {
    @ManyToOne
    @JoinColumn(name="EMPLOYER_ID")
    protected Organization employer;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="JOB_ID")
    protected Set<AssetWish> assetWishSet;

    public Set<AssetWish> getAssetWishSet() {
        return assetWishSet;
    }

    public Job(Set<Definition> definitionSet, Organization employer, Set<AssetWish> assetWishSet) {
        super(definitionSet);
        this.employer = employer;
        this.assetWishSet = assetWishSet;
    }

    public Job(Organization employer, Set<AssetWish> assetWishSet) {
        this.employer = employer;
        this.assetWishSet = assetWishSet;
    }

    public void setAssetWishSet(Set<AssetWish> assetWishSet) {
        this.assetWishSet = assetWishSet;
    }

    public Organization<Definition> getEmployer() {
        return employer;
    }

    public void setEmployer(Organization employer) {
        this.employer = employer;
    }
}
