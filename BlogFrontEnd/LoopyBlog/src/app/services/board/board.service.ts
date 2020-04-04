import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class BoardService {

  public API = 'http://loopyblog.herokuapp.com/';

  constructor(private http: HttpClient) { }

  getPosts(): Observable<any> {
    return this.http.get(this.API + 'boards/list');
  }

  get(id: number) {
    return this.http.get(this.API + 'boards/' + id);
  }

  save(post: any): Observable<any> {
    let result: Observable<any>;
    if (post.href) {
      result = this.http.put(post.href, post);
    } else {
      result = this.http.post(this.API + 'boards/', post);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
