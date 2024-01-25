import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-book-dialog',
  templateUrl: './add-book-dialog.component.html',
  styleUrl: './add-book-dialog.component.css'
})
export class AddBookDialogComponent implements OnInit {

  book = {
    bookID: 0,
    title: 'titel',
    author: 'author',
    isbn: '1234'
  };

  constructor(
    public dialogRef: MatDialogRef<AddBookDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    console.log('data.bookID: ', data.bookID);

    if (data && data.bookID) {
      this.book.bookID = data.bookID;
    }
  }

  ngOnInit(): void {
    // Initialisieren Sie hier Ihre Dialogdaten oder Logik
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  createBook() {
    // Hier kannst du die Logik zum Erstellen des Buchs implementieren
    console.log('Add Book:', this.book);
    // Schließe das Dialogfenster und übergebe das erstellte Buch
    this.dialogRef.close(this.book);
  }

  closeDialog() {
    // Schließe das Dialogfenster ohne etwas zu erstellen
    this.dialogRef.close();
  }
}
