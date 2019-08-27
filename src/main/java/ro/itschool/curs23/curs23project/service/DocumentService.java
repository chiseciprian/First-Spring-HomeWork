package ro.itschool.curs23.curs23project.service;

import org.springframework.stereotype.Service;
import ro.itschool.curs23.curs23project.model.Document;
import ro.itschool.curs23.curs23project.model.Markup;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

@Service
public class DocumentService {
    private final List<Document> documents = new ArrayList<>();

    private final List<Markup> markups = new ArrayList<>();

    public List<Document> getDocuments(String name) {
        return ofNullable(name)
                .map(this::getByName)
                .orElse(documents);
    }


    public Document getDocumentById(String documentId) {
        return documents.stream()
                .filter(document -> document.getDocumentId().equals(documentId))
                .findFirst()
                .orElse(null);
    }

    public Document addDocument(Document document) {
        document.setDocumentId(UUID.randomUUID().toString());
        documents.add(document);
        return null;
    }

    public Markup addMarkup(String documentId,Markup markup){
        markup.setDocumentId(documentId);
        markups.add(markup);
        return null;
    }

    public Document updateDocument(String documentId, Document document) {
        final Document existingDocument = getDocumentById(documentId);
        if (existingDocument != null) {
            document.setDocumentId(documentId);
            documents.remove(existingDocument);
            documents.add(document);
            return existingDocument;
        } else {
            return null;
        }
    }

    public Markup updateMarkup(String documentId,String markupId,Markup markup){
        final Markup existingMarkup=getMatkupsById(documentId,markupId);
        if (existingMarkup!=null){
            markup.setMarkupId(markupId);
            markup.setDocumentId(documentId);
            markups.remove(existingMarkup);
            markups.add(markup);
            return existingMarkup;
        }else {
            return null;
        }
    }

    public Document deleteDocument(String documentId) {
        final Document document = getDocumentById(documentId);
        if (documents.remove(document)) {
            return document;
        } else {
            return null;
        }
    }

    public Markup deleteMarkup(String documentId,String markupId){
        final Markup markup=getMatkupsById(documentId,markupId);
        if (markups.remove(markup)){
            return markup;
        }else {
            return null;
        }
    }

    public List<Markup> getMarkups(String documentId){
        return ofNullable(documentId)
                .map(this::getByDocumentId)
                .orElse(markups);
    }

    public Markup getMatkupsById(String documentId,String markupId){
        List<Markup>documentMarkup=getMarkups(documentId);
       return documentMarkup.stream()
                .filter(markup -> markup.getMarkupId().equals(markupId))
                .findFirst()
                .orElse(null);
    }

    private List<Markup>  getByDocumentId(String documentId) {
        return markups.stream()
                .filter(markup -> markup.getDocumentId().equals(documentId))
                .collect(toList());
    }




    private List<Document> getByName(String name) {
        return documents.stream()
                .filter(document -> document.getName().equals(name))
                .collect(toList());
    }

    private List<Document> getByOwner(String owner) {
        return documents.stream()
                .filter((document -> document.getOwner().equals(owner)))
                .collect(toList());
    }


}
