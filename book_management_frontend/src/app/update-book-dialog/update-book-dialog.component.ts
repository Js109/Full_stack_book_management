import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-update-book-dialog',
  templateUrl: './update-book-dialog.component.html',
  styleUrl: './update-book-dialog.component.css'
})
export class UpdateBookDialogComponent implements OnInit {
  book = {
    bookID: 0,
    title: 'titel',
    author: 'author',
    isbn: '1234'
  };

  constructor(
    public dialogRef: MatDialogRef<UpdateBookDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    console.log('data.bookID: ', data.selectedBook);

    if (data) {
      this.book = data.selectedBook;
    }
  }

  ngOnInit(): void {
    // Initialisieren Sie hier Ihre Dialogdaten oder Logik
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  updateBook() {
    console.log('Update Book:', this.book);
    // Close dialogwindow without and hand over the updated book
    this.dialogRef.close(this.book);
  }

  closeDialog() {
    // Close dialogwindow without any effect
    this.dialogRef.close();
  }
}
