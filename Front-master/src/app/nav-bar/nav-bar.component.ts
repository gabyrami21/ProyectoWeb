import { Component, OnInit } from '@angular/core';
import {Book} from "../book";
import {BookService} from "../book.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  reinicio: string=""
  books: Book[]=[];
  constructor(private bookService: BookService) { }

  ngOnInit(): void {
  }

  buscar(searchForm: NgForm){
    this.bookService.searchByName(searchForm.value.filter);
  }

  reiniciarPag():void{
    this.bookService.searchAllBooks();
    this.reinicio='';
}
}
