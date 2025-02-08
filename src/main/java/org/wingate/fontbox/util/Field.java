package org.wingate.fontbox.util;

import java.util.ArrayList;
import java.util.List;

public class Field<Unit> {
    protected String name;
    protected String description;
    protected Unit unit;

    protected List<Field<?>> innerFields;

    public Field(Unit unit) {
        this.unit = unit;
        name = null;
        description = null;

        innerFields = new ArrayList<>();
    }

    public Field() {
        this(null);
        name = null;
        description = null;

        innerFields = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public List<Field<?>> getInnerFields() {
        return innerFields;
    }

    public void setInnerFields(List<Field<?>> innerFields) {
        this.innerFields = innerFields;
    }
}
