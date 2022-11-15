import { Component, OnInit } from '@angular/core';
import {BookService} from "../book.service";
import {Book} from "../book";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  books: Book[]=[];
  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.bookService.searchAllBooks();
    this.bookService.OnResults().subscribe(
      results => this.books = results
    )
  }
  searchBooksByEditorial(book: Book): Book[]{
    return this.books;
  }

}
