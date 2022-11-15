import { Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {Book} from "./book";

@Injectable({
  providedIn: "root"
})
export class BookService {

  searchResults = new BehaviorSubject<Array<Book>>([]);

  constructor(private http: HttpClient) {
  }

  searchAllBooks() {
    this.http.get<Book[]>("http://localhost:8081/public/books").subscribe(
      results => {
        console.log(results);
        this.searchResults.next(results)
      }
    );
  }

  searchByName(name: string) {
    this.http.get<Book[]>("http://localhost:8081/book/" + name).subscribe(
      results => this.searchResults.next(results)
    );
  }

  OnResults() {
    return this.searchResults.asObservable();
  }
}
