package org.wingate.fontbox.util;

import java.util.ArrayList;
import java.util.List;

public class Entity {
    protected String name;
    protected String description;
    protected long offset;
    protected long length;
    protected String checksum;

    protected List<Field<?>> fields;
    protected List<String> helpLinks;

    public Entity() {
        name = null;
        description = null;
        offset = 0L;
        length = 0L;
        checksum = null;
        fields = new ArrayList<>();
        helpLinks = new ArrayList<>();
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

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public List<Field<?>> getFields() {
        return fields;
    }

    public void setFields(List<Field<?>> fields) {
        this.fields = fields;
    }

    public List<String> getHelpLinks() {
        return helpLinks;
    }

    public void setHelpLinks(List<String> helpLinks) {
        this.helpLinks = helpLinks;
    }
}
