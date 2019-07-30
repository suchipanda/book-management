import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http";
import { Book } from './book';



@Injectable({
  providedIn: 'root'
})
export class BookService {

constructor(private http:HttpClient) { }

getAllBook():Observable<any>{  
  return this.http.get("http://localhost:8080/api/getBoooks");
}
addBook(book:Book, id:number):Observable<any>{
  console.log(id);
  return this.http.post("http://localhost:8080/api/addbook/"+id,book);
}

public getAllLibrary():Observable<any> {
  return this.http.get("http://localhost:8080/getAllLibrary");

}
}

  

