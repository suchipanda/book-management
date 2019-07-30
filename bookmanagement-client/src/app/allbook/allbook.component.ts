import { Component, OnInit } from '@angular/core';
import {Book} from '../service/book';
import {BookService} from '../service/book.service';
import { from, Observable } from 'rxjs';
import { DeletebookComponent } from '../deletebook/deletebook.component';

@Component({
  selector: 'app-allbook',
  templateUrl: './allbook.component.html',
  styleUrls: ['./allbook.component.css']
})
export class AllbookComponent implements OnInit {
  books: Observable<any>;
    constructor(private bookService: BookService) { }
      

  ngOnInit(){    
    this.bookService.getAllBook().
                  subscribe(data => {this.books =data});       
    
      }
      deleteBook(id:number){
        this.bookService.deleteBook(id).
        subscribe(data =>{
          console.log(data);
          this.bookService.getAllBook().subscribe(data =>{this.books = data})
        },
        error =>console.log(error));  

      }
      

}
