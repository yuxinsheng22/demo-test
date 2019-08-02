package com.yuxinsheng.demotest.thread.pool.test;

public class TracingObject {

    private Integer id;

    private String name;

    private String content;

    private String description;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "id:" + id
                + "\t name:" + name
                + "\t content:" + content
                + "\t description:" + description
                + "\t type:" + type;
    }

    public TracingObject(Integer id, String name, String content,
                         String description, Integer type) {
        super();
        this.id = id;
        this.name = name;
        this.content = content;
        this.description = description;
        this.type = type;
    }
}
