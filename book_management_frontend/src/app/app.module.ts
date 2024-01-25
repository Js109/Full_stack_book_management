import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookTableComponent } from './book-table/book-table.component';
import { BookService } from './book-table/book.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddBookDialogComponent } from './add-book-dialog/add-book-dialog.component';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { UpdateBookDialogComponent } from './update-book-dialog/update-book-dialog.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    BookTableComponent,
    AddBookDialogComponent,
    UpdateBookDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatDialogModule,
    FormsModule
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
