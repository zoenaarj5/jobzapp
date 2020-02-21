package org.kavus.jobzapp.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Definable<T extends Definition> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="DEFINABLE_ID")
    protected Set<Definition> definitionSet;
    @Transient
    protected T currentDefinition;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Definition> getDefinitionSet() {
        return definitionSet;
    }

    public void setDefinitionSet(Set<Definition> definitionSet) {
        this.definitionSet = definitionSet;
        translate();
    }

    public T getCurrentDefinition() {
        return currentDefinition;
    }

    public Definable(Set<Definition> definitionSet) {
        setDefinitionSet(definitionSet);
    }

    public void setCurrentDefinition(T currentDefinition) {
        this.currentDefinition = currentDefinition;
    }

    public Definable() {
        super();
    }

    public void translate(){
        if(definitionSet ==null){
            return;
        }
        final Set<Definition> defSet= definitionSet;
        Object[] oTab=defSet.stream().filter((def)->def.getLanguageCode()==Definition.getCurrentLanguageCode()).toArray();
        this.currentDefinition=(oTab.length>0)?(T)oTab[0]:null;
    }
}
