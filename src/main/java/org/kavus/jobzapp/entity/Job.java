package org.kavus.jobzapp.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Job extends Definable<LDefinition> {
    @ManyToOne
    @JoinColumn(name="EMPLOYER_ID")
    protected Organization employer;
    @OneToMany
    @JoinColumn(name="JOB_ID")
    protected List<AssetWish> assetWishList;

    public List<AssetWish> getAssetWishList() {
        return assetWishList;
    }

    public Job(List<Definition> definitionList, Organization employer, List<AssetWish> assetWishList) {
        super(definitionList);
        this.employer = employer;
        this.assetWishList = assetWishList;
    }

    public Job(Organization employer, List<AssetWish> assetWishList) {
        this.employer = employer;
        this.assetWishList = assetWishList;
    }

    public void setAssetWishList(List<AssetWish> assetWishList) {
        this.assetWishList = assetWishList;
    }

    public Organization<Definition> getEmployer() {
        return employer;
    }

    public void setEmployer(Organization employer) {
        this.employer = employer;
    }
}
