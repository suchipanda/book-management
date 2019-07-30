import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators,} from "@angular/forms";
import {Router} from "@angular/router";
import {BookService} from '../service/book.service';
import { Book } from '../service/book';
import { Library } from '../service/library';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent implements OnInit {

  constructor(private formBuilder:FormBuilder,private router:Router,private bookService: BookService) { }

  addForm:FormGroup;
  book:Book = new Book();
  libs: Observable<any>;
  libId: number;
  
  ngOnInit() {
    this.addForm = this.formBuilder.group({
      name: ['',Validators.required],
      author: ['',Validators.required],
      price: ['',Validators.required]

  });

  this.bookService.getAllLibrary().
                  subscribe(data => {
                    this.libs =data;
                  });

}
onSubmit() {
  console.log(this.book);
  this.bookService.addBook(this.book, this.libId)
    .subscribe( data => {
      this.router.navigate(['allbook']), alert("Book added Succesfully");
    });
}

onNameChange(libId: any){  
  this.libId = libId;
  console.log(this.libId);  
}
}
