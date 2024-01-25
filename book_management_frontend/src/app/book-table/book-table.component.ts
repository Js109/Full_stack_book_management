import { Component, OnInit } from '@angular/core';
import { BookService } from './book.service';
import { Book } from './book.model';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { AddBookDialogComponent } from '../add-book-dialog/add-book-dialog.component';
import { UpdateBookDialogComponent } from '../update-book-dialog/update-book-dialog.component';


@Component({
  selector: 'app-book-table',
  templateUrl: './book-table.component.html',
  styleUrl: './book-table.component.css'
})
export class BookTableComponent implements OnInit {
  books: Book[] = [];
  selectedBook: Book | null = null;

  constructor(private bookService: BookService,
    private dialog: MatDialog) { }

  ngOnInit() {
    this.loadBooks();
  }

  loadBooks() {
    this.bookService.getAllBooks().subscribe(
      (data: any) => {
        if (Array.isArray(data.bookList)) {
          this.books = data.bookList;
        } else {
          console.error('Invalid response structure. An array was expected.');
        }
      },
      (error) => {
        console.error('Error while loading the books', error);
      }
    );
  }

  addBook(): void {
    // example: add new book
    let bookID: number = 0;
    if (this.books.length > 0) {
      bookID = this.books[this.books.length - 1].bookID + 1;
    }

    const dialogRef = this.dialog.open(AddBookDialogComponent, {
      width: '500px',
      height: '400px',
      // put data in the AddBookDialogComponent
      data: { bookID: bookID }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        console.log('AddDialog closed:', result);
        this.bookService.addBook(result).subscribe(
          (addedBook) => {
            console.log('Book added successfully:', addedBook);
            this.books.push(result);
          },
          (error) => {
            console.error('Error adding book:', error);
          }
        );
      } else {
        console.log('Adddialog without result');
      }
    });
  }



  updateBook(): void {
    if (this.selectedBook && this.books.length > 0) {

      const dialogRef = this.dialog.open(UpdateBookDialogComponent, {
        width: '500px',
        height: '500px',
        // put data in the UpdateBookDialogComponent
        data: { selectedBook: this.selectedBook }
      });

      dialogRef.afterClosed().subscribe(result => {
        if (result) {
          console.log('Updatedialog closed:', result);
          this.bookService.updateBook(result).subscribe(
            (updatedBook) => {
              console.log('Book updated successfully:', updatedBook);

            },
            (error) => {
              console.error('Error updateing book:', error);
            }
          );
        } else {
          console.log('Updatedialog without result');
        }
      });
    }
  }


  deleteBook() {
    if (this.selectedBook) {
      const index = this.books.indexOf(this.selectedBook);
      this.bookService.deleteBookByID(this.selectedBook.bookID).subscribe(
        () => {
          console.log('Book deleted successfully');
          if (index !== -1) {
            this.books.splice(index, 1);
            this.selectedBook = null; // Set selectedBook to null, because it is not existing anymore
          }
        },
        (error) => {
          console.error('Error deleting book:', error)
        }
      )
    }
  }

  selectBook(book: Book) {
    this.selectedBook = book;
  }

}
