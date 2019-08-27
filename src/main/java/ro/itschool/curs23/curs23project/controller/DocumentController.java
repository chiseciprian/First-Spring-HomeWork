package ro.itschool.curs23.curs23project.controller;

import org.springframework.web.bind.annotation.*;
import ro.itschool.curs23.curs23project.model.Document;
import ro.itschool.curs23.curs23project.model.Markup;
import ro.itschool.curs23.curs23project.service.DocumentService;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    List<Document> getDocuments(@RequestParam(required = false) String name){
        return documentService.getDocuments(name);
    }

    @GetMapping("{documentId}")
    Document getDocumentById(@PathVariable String documentId){
        return documentService.getDocumentById(documentId);
    }

    @GetMapping("{documentId}/markups")
    List<Markup> getMarkups(@PathVariable String documentId){
        return documentService.getMarkups(documentId);
    }

    @GetMapping("{documentId}/markups/{markupId}")
    Markup getMarkupById(@PathVariable String documentId, @PathVariable String markupId){
        return documentService.getMatkupsById(documentId,markupId);
    }

    @PostMapping
    Document addDocument(@RequestBody Document document){
        return documentService.addDocument(document);
    }

    @PostMapping("{documentId}/markups")
    Markup addMarkup(@PathVariable String documentId,@RequestBody Markup markup){
        return documentService.addMarkup(documentId,markup);
    }

    @PutMapping("{documentId}")
    Document updateDocument(@PathVariable String documentId,@RequestBody Document document){
        return documentService.updateDocument(documentId,document);
    }

    @PutMapping("{documentId}/markups/{markupId}")
        Markup updateMarkup(@PathVariable String documentId,@PathVariable String markupId,@RequestBody Markup markup){
        return documentService.updateMarkup(documentId,markupId,markup);
    }


    @DeleteMapping("{documentId}")
    Document deleteDocument(@PathVariable String documentId){
        return documentService.deleteDocument(documentId);
    }

    @DeleteMapping("{documentId}/markups/{markupId}")
    Markup deleteMarkup(@PathVariable String documentId, @PathVariable String markupId){
        return documentService.deleteMarkup(documentId,markupId);
    }


}
