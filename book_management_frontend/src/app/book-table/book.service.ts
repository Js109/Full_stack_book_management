import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './book.model';
import { catchError } from 'rxjs/operators';

@Injectable({
    providedIn: 'root',
})
export class BookService {
    private apiUrl = 'http://localhost:8081/api';

    constructor(private http: HttpClient) { }

    getAllBooks(): Observable<Book[]> {
        return this.http.get<Book[]>(this.apiUrl+"/getBooks");
    }

    addBook(newBook: Book): Observable<Book> {
        const httpOptions = {
          headers: new HttpHeaders({
            'Content-Type': 'application/json',
          }),
        };
    
        return this.http.post<Book>(`${this.apiUrl}/addBook`, newBook, httpOptions)
          .pipe(
            catchError((error) => {
              console.error('Error adding book:', error);
              throw error;
            })
          );
      }

    deleteBookByID(bookID: number): Observable<void> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
            }),
        };

        return this.http.delete<void>(`${this.apiUrl}/deleteBook?bookID=${bookID}`, httpOptions)
        .pipe(
            catchError((error) => {
              console.error('Error deleting book:', error);
              throw error;
            })
          );
    }
    
    updateBook(book: any): Observable<any> {
        const url = `${this.apiUrl}/updateBook`;

        const headers = new HttpHeaders({ 'Content-Type': 'application/json'});

        return this.http.put(url, book, {headers});
    }
}
