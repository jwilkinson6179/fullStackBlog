import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PostService {

  public API = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getPosts(): Observable<any> {
    return this.http.get(this.API + 'posts/list');
  }

  get(id: number) {
    return this.http.get(this.API + 'posts/' + id);
  }

  getBoard(id: number) {
    return this.http.get('http://localhost:8080/boards/actual/' + id);
  }

  save(post: any, id: number): Observable<any> {
    console.log('SELECTED ID: ' + id);
    post.board = this.getBoard(id);
    console.log('POST BOARD: ' + post.board.title);
    let result: Observable<any>;
    if (post.href) {
      result = this.http.put(post.href, post);
    } else {
      result = this.http.post(this.API + 'posts/', post);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
