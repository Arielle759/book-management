package sn.iage.isi.main;

import sn.iage.isi.entities.Book;
import sn.iage.isi.entities.Category;
import sn.iage.isi.repositories.BookRepository;
import sn.iage.isi.repositories.CategoryRepository;

public class Main {
    public static void main(String[] args) {

        BookRepository bookRepo = new BookRepository();
        CategoryRepository catRepo = new CategoryRepository();

        // Récupérer une catégorie existante
        Category cat = catRepo.getById(1);

        // createBook
        Book newBook = Book.builder()
                .title("Les Bouts de bois de Dieu")
                .author("Ousmane Sembène")
                .publicationYear(1960)
                .countPages(384)
                .category(cat)
                .build();
        Book created = bookRepo.createBook(newBook);
        System.out.println("Créé : " + created);

        // listAllBooks
        System.out.println("Tous les livres : " + bookRepo.listAllBooks());

        // findBookById
        System.out.println("Par id : " + bookRepo.findBookById(created.getId()));

        // findBookByIsbn
        System.out.println("Par ISBN : " + bookRepo.findBookByIsbn(created.getIsbn()));

        // searchBooksByTitle
        System.out.println("Recherche titre 'bouts' : " + bookRepo.searchBooksByTitle("bouts"));

        // searchBooksByAuthor
        System.out.println("Recherche auteur 'sembène' : " + bookRepo.searchBooksByAuthor("sembène"));

        // searchBooksAfterYear
        System.out.println("Après 1950 : " + bookRepo.searchBooksAfterYear(1950));

        // listeBooksByCategory
        System.out.println("Par catégorie : " + bookRepo.listeBooksByCategory(cat.getName()));

        // countAllBooks
        System.out.println("Total livres : " + bookRepo.countAllBooks());

        // countBooksByCategory
        System.out.println("Nb catégories avec livres : " + bookRepo.countBooksByCategory());

        // updateBook
        Book updatedBook = Book.builder()
                .title("L'Aventure ambiguë")
                .author("Cheikh Hamidou Kane")
                .publicationYear(1961)
                .countPages(192)
                .category(cat)
                .build();
        bookRepo.updateBook(created.getId(), updatedBook);
        System.out.println("Après update : " + bookRepo.findBookById(created.getId()));

        // deleteBook
        bookRepo.deleteBook(created.getId());
        System.out.println("Livre supprimé.");
    }
}