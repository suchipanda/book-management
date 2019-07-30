import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http";
import { Book } from './book';



@Injectable({
  providedIn: 'root'
})
export class BookService {

constructor(private http:HttpClient) { }

public getAllBook():Observable<any>{  
  return this.http.get("http://localhost:8080/api/getBoooks");
}
public addBook(book:Book, id:number):Observable<any>{
  console.log(id);
  return this.http.post("http://localhost:8080/api/addbook/"+id,book);
}

public getBookById(id:number):Observable<any>{
  return this.http.get("http://localhost:8080/api/getbook/"+id);
}

public getAllLibrary():Observable<any> {
  return this.http.get("http://localhost:8080/getAllLibrary");

}
public deleteBook(id:number):Observable<any>{
  return this.http.delete("http://localhost:8080/api/deleteBook/"+id, { responseType: 'text' });
}
public updateBook(id:number, value:any):Observable<any>{
  return this.http.post("http://localhost:8080/api/updateBook/"+id, value);
}
}

  

