package org.kavus.jobzapp.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class AssetWish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    @ManyToOne
    @JoinColumn(name = "ASSET_ID")
    protected Asset asset;
    @Enumerated(EnumType.STRING)
    protected AssetWishLevel wishLevel;
    @Length
    protected String comment;

    public AssetWish() {
        super();
    }

    public AssetWish(Asset asset, AssetWishLevel wishLevel, @Length String comment) {
        this.asset = asset;
        this.wishLevel = wishLevel;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public AssetWishLevel getWishLevel() {
        return wishLevel;
    }

    public void setWishLevel(AssetWishLevel wishLevel) {
        this.wishLevel = wishLevel;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
