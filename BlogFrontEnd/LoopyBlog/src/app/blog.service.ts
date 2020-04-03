import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private endpoint = 'http://localhost:8080/posts/1';
  constructor(private http: HttpClient) { }

  getPosts(){
    return this.http.get(this.endpoint);
  }
}
