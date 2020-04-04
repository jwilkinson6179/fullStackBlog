import { Component, OnInit } from '@angular/core';
import {PostService} from '../blog.service';
import { GiphyService } from '../shared/giphy.service';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.scss']
})
export class PostListComponent implements OnInit {

  posts: Array<any>;

  constructor(private postService: PostService, private giphyService: GiphyService) { }

  ngOnInit() {
    this.postService.getPosts().subscribe(data => {
      this.posts = data;
      for (const post of this.posts) {
        this.giphyService.get(post.id).subscribe(url => post.imageUrl = url);
      }
    });
  }

}
