package ro.itschool.curs23.curs23project.model;

import java.util.Objects;

public class Document {
    private String documentId;
    private String name;
    private String content;
    private String owner;

    public Document(String documentId, String name, String content, String owner) {
        this.documentId = documentId;
        this.name = name;
        this.content = content;
        this.owner = owner;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getOwner() {
        return owner;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document documnet = (Document) o;
        return Objects.equals(documentId, documnet.documentId) &&
                Objects.equals(name, documnet.name) &&
                Objects.equals(content, documnet.content) &&
                Objects.equals(owner, documnet.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId, name, content, owner);
    }
}
