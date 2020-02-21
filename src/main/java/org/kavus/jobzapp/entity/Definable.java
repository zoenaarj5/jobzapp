package org.kavus.jobzapp.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Definable<T extends Definition> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="DEFINITION_LIST")
    protected List<Definition> definitionList;
    @Transient
    protected T currentDefinition;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Definition> getDefinitionList() {
        return definitionList;
    }

    public void setDefinitionList(List<Definition> definitionList) {
        this.definitionList = definitionList;
        translate();
    }

    public T getCurrentDefinition() {
        return currentDefinition;
    }

    public Definable(List<Definition> definitionList) {
        setDefinitionList(definitionList);
    }

    public void setCurrentDefinition(T currentDefinition) {
        this.currentDefinition = currentDefinition;
    }

    public Definable() {
        super();
    }

    public void translate(){
        if(definitionList==null){
            return;
        }
        final List<Definition> defList=definitionList;
        List<Object> oList= Arrays.asList(defList.stream().filter((def)->def.getLanguageCode()==Definition.getCurrentLanguageCode()).toArray());
        this.currentDefinition=(defList.size()>0)?(T)oList.get(0):null;
    }
}
