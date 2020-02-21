package org.kavus.jobzapp.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AssetLister {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="LISTER_ID")
    protected Set<Asset> assetSet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Asset> getAssetSet() {
        return assetSet;
    }

    public void setAssetSet(Set<Asset> assetSet) {
        this.assetSet = assetSet;
    }
}
