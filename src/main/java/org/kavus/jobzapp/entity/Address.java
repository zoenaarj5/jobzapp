package org.kavus.jobzapp.entity;

import javax.persistence.*;

@Entity
public class Address extends Contact{
    public AddressData getAddressData() {
        return addressData;
    }

    public void setAddressData(AddressData addressData) {
        this.addressData = addressData;
    }

    @Embedded
    @AttributeOverrides(value = {
        @AttributeOverride(name="streetName",column = @Column(name="STREET_NAME")),
        @AttributeOverride(name="streetNumber",column = @Column(name="STREET_NUMBER")),
        @AttributeOverride(name="streetBox",column = @Column(name="STREET_BOX")),
        @AttributeOverride(name="zipCode",column = @Column(name="ZIP_CODE")),
        @AttributeOverride(name="poBox",column = @Column(name="PO_BOX")),
        @AttributeOverride(name="city",column = @Column(name="CITY")),
        @AttributeOverride(name="countryCode",column = @Column(name="COUNTRY_CODE"))
    })
    protected AddressData addressData;
}